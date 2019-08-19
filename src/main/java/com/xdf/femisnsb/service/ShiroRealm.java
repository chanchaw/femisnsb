package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.model.PermRoleUser;
import com.xdf.femisnsb.model.PermUser;
import com.xdf.femisnsb.model.PermUserPermission;

@Service
public class ShiroRealm extends AuthorizingRealm {
	
	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

	@Autowired
	private PermUserService service;

	//��Ȩ����
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		logger.info("��������Ȩ����");
		
		//1. ��ȡ��¼�û�����Ϣ
		Object principal=principals.getPrimaryPrincipal();//��ȡ���������еĵ�һ��
		logger.info("������֤token�л�ȡ������֤�����ǣ�" + principal.toString());

		
		//2. ��ȡ��ǰ�û��Ľ�ɫ��Ȩ��
		Set<String> roles = new HashSet<String>();
		List<PermRoleUser> roleList = service.getRolesByUserId(principal.toString());
		logger.info("���û�ӵ�еĽ�ɫ�ǣ�" + roleList.toString());

		for (PermRoleUser permRoleUser : roleList) {
			roles.add(permRoleUser.getRolename());
		}
		logger.info("������䵽SimpleAuthorizationInfo��roles�ǣ�" + roles.toString());

		//3. ����SimpleAuthorizationInfo
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		
		
		//4. ����Ȩ�޼���
		List<PermUserPermission> list = new ArrayList<PermUserPermission>();
		list = service.getAclsByUserId(principal.toString());
		logger.info("�ӷ�����ȡ��Ȩ���ǣ�" + list.toString());
		
		
		List<String> permissions = new ArrayList<String>();
		if(list!=null && list.size()>0) {
			for (PermUserPermission ele : list) {
				permissions.add(ele.getAclModuleName() + ":" + ele.getAclCode());
			}
		}
		info.addStringPermissions(permissions);
		
		logger.info("��ǰ�û�ӵ�е�Ȩ���ǣ�" + permissions.toString());
		logger.info("�������ص�info:" + info.toString());
		//4. ����SimpleAuthorizationInfo
		return info;
	}

	//��֤����
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		logger.info("����ʱ���õ�AuthenticationToken��" + token.toString());
		
		
		//�������ķ��ؽ��
		SimpleAuthenticationInfo info = null;
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		logger.info("ǿ������ת��ΪUsernamePasswordToken��" + upToken.toString());

		String userid = upToken.getUsername();
		
		List<PermUser> users = null;
		try {
			users = service.getByUserid(userid);
		} catch (Exception e) {
			logger.info("ͨ��������ȡ�����û��б��ǣ�"+users.toString());
		}
		
		
		if(users.size()<=0) {// �˺Ų�����
			logger.info("�˺Ų����ڣ�");
			throw new UnknownAccountException("���Ų����ڣ�");
		}
		
		for (PermUser permUser : users) {
			if(isLocked(permUser.getStatus())) {
				logger.info("�˻���������");
				throw new LockedAccountException("�˻���������");
			}
		}
		
		PermUser user = users.get(0);
		logger.info("�û��б�ĵ�һ���û��ǣ�" + user.toString());
		
		String uiPwdOrigin = String.valueOf(upToken.getPassword());
		logger.info("UI�е����������ǣ�" + uiPwdOrigin);
		//String encryptUIPwd = encryptPassword(uiPwdOrigin,user.getId().toString());
		//String encryptUIPwd = uiPwdOrigin;
		
		// ��ʼ��֤����
		Object principal = userid;
		String realmName = super.getName();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId().toString());// ׼����ֵ - ʹ������
		Object credentials = user.getPassword();//DB�е����� - ��ȷ������
		logger.info("DB�еļ��ܺ�������ǣ�" + credentials.toString());
		
		/*
		 * 
		 shiro�Դ���֤����Ĺ��ܣ������Լ�����
		if(checkPwd(credentials,encryptUIPwd)==false) {
			System.out.println("ShiroRealm�е���֤�������������");
			IncorrectCredentialsException ie = new IncorrectCredentialsException("�������");
			System.out.println("�����׳����쳣�����ǣ�" + ie.toString());
			throw ie;
		}
		*/
		
		try {
			info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);//��ֵ����
			logger.info("��������SimpleAuthenticationInfo����" + info);
		} catch (Exception e) {
			logger.info("����SimpleAuthenticationInfoʱ�����");
		}
			
		return info;
	}
	
	/*
	 * 
	 * ��2018��11��24�� 16:23:26�޸�Ϊʹ��shiro�Դ�����֤����Ĺ���
	 * ������ע�͵�����ʹ��
	private boolean checkPwd(Object credentials,String uiPwd){
		String dbPwd = credentials.toString();
		if(dbPwd.equals(uiPwd)) {
			return true;
		}else {
			return false;
		}
	}
	*/
	
	
	/*
	 * �����ļ�applicationContext.xml����������������ò��ԣ�
	 * 1. ʹ�ñ�PermUser�е�����id��Ϊ��ֵ
	 * 2. ʹ��MD5��ʽ����
	 * 3. ����1024��
	 * 
	 * ��������������Ĺ����ַ������ܲ��ҷ���
	 * ����UIҳ�洫����������������ܺ󷵻�
	 * ���ں�DB�б���ļ�������Ա���֤�������ȷ��
	 */
	private String encryptPassword(String password,String vSalt) {
		String hashAlgorithmName="MD5";
		Object credentials=password;
		Object salt = ByteSource.Util.bytes(vSalt);
		Integer hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
		
		// ���ؼ��ܺ������
		return result.toString();
	}
	
		 
//	public static void main(String[] args) {
//		String saltString = "1"; 
//		String hashAlgorithmName="MD5";
//		Object credentials="123";
//		Object salt = ByteSource.Util.bytes(saltString);
//		Integer hashIterations = 1024;
//		Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
//		
//		System.out.println("�����㷨��" + hashAlgorithmName);
//		System.out.println("���룺" + credentials);
//		System.out.println("��ֵ��" + saltString);
//		System.out.println("���ܺ�����룺"+result);
//	}
	
	
	/**
	 * �жϵ�ǰ�û��Ƿ�����
	 * @param status
	 * @return
	 */
	private boolean isLocked(Integer status) {
		boolean rtn = false;
		if(null==status)
			status=1;
		if(status==0)
			rtn = true;
		else 
			rtn = false;
		
		return rtn;
	}
}
