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

	//授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		logger.info("进入了授权方法");
		
		//1. 获取登录用户的信息
		Object principal=principals.getPrimaryPrincipal();//获取返回数组中的第一个
		logger.info("从已认证token中获取到的认证主体是：" + principal.toString());

		
		//2. 获取当前用户的角色和权限
		Set<String> roles = new HashSet<String>();
		List<PermRoleUser> roleList = service.getRolesByUserId(principal.toString());
		logger.info("该用户拥有的角色是：" + roleList.toString());

		for (PermRoleUser permRoleUser : roleList) {
			roles.add(permRoleUser.getRolename());
		}
		logger.info("即将填充到SimpleAuthorizationInfo的roles是：" + roles.toString());

		//3. 创建SimpleAuthorizationInfo
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		
		
		//4. 创建权限集合
		List<PermUserPermission> list = new ArrayList<PermUserPermission>();
		list = service.getAclsByUserId(principal.toString());
		logger.info("从服务层获取的权限是：" + list.toString());
		
		
		List<String> permissions = new ArrayList<String>();
		if(list!=null && list.size()>0) {
			for (PermUserPermission ele : list) {
				permissions.add(ele.getAclModuleName() + ":" + ele.getAclCode());
			}
		}
		info.addStringPermissions(permissions);
		
		logger.info("当前用户拥有的权限是：" + permissions.toString());
		logger.info("即将返回的info:" + info.toString());
		//4. 返回SimpleAuthorizationInfo
		return info;
	}

	//认证方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		logger.info("进入时候获得的AuthenticationToken：" + token.toString());
		
		
		//本方法的返回结果
		SimpleAuthenticationInfo info = null;
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		logger.info("强制类型转换为UsernamePasswordToken后：" + upToken.toString());

		String userid = upToken.getUsername();
		
		List<PermUser> users = null;
		try {
			users = service.getByUserid(userid);
		} catch (Exception e) {
			logger.info("通过服务层获取到的用户列表是："+users.toString());
		}
		
		
		if(users.size()<=0) {// 账号不存在
			logger.info("账号不存在！");
			throw new UnknownAccountException("工号不存在！");
		}
		
		for (PermUser permUser : users) {
			if(isLocked(permUser.getStatus())) {
				logger.info("账户被锁定！");
				throw new LockedAccountException("账户被锁定！");
			}
		}
		
		PermUser user = users.get(0);
		logger.info("用户列表的第一个用户是：" + user.toString());
		
		String uiPwdOrigin = String.valueOf(upToken.getPassword());
		logger.info("UI中的明文密码是：" + uiPwdOrigin);
		//String encryptUIPwd = encryptPassword(uiPwdOrigin,user.getId().toString());
		//String encryptUIPwd = uiPwdOrigin;
		
		// 开始验证密码
		Object principal = userid;
		String realmName = super.getName();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId().toString());// 准备盐值 - 使用主键
		Object credentials = user.getPassword();//DB中的密码 - 正确的密码
		logger.info("DB中的加密后的密码是：" + credentials.toString());
		
		/*
		 * 
		 shiro自带验证密码的功能，不用自己检验
		if(checkPwd(credentials,encryptUIPwd)==false) {
			System.out.println("ShiroRealm中的认证方法中密码错误");
			IncorrectCredentialsException ie = new IncorrectCredentialsException("密码错误！");
			System.out.println("即将抛出的异常对象是：" + ie.toString());
			throw ie;
		}
		*/
		
		try {
			info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);//盐值加密
			logger.info("即将返回SimpleAuthenticationInfo对象：" + info);
		} catch (Exception e) {
			logger.info("创建SimpleAuthenticationInfo时候出错！");
		}
			
		return info;
	}
	
	/*
	 * 
	 * 在2018年11月24日 16:23:26修改为使用shiro自带的验证密码的功能
	 * 本方法注释掉不再使用
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
	 * 配置文件applicationContext.xml中做好了密码的配置策略：
	 * 1. 使用表PermUser中的主键id作为盐值
	 * 2. 使用MD5方式加密
	 * 3. 加密1024次
	 * 
	 * 本方法按照上面的规则将字符串加密并且返回
	 * 即将UI页面传递来的明文密码加密后返回
	 * 用于和DB中保存的加密密码对比验证密码的正确性
	 */
	private String encryptPassword(String password,String vSalt) {
		String hashAlgorithmName="MD5";
		Object credentials=password;
		Object salt = ByteSource.Util.bytes(vSalt);
		Integer hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
		
		// 返回加密后的密码
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
//		System.out.println("加密算法：" + hashAlgorithmName);
//		System.out.println("密码：" + credentials);
//		System.out.println("盐值：" + saltString);
//		System.out.println("加密后的密码："+result);
//	}
	
	
	/**
	 * 判断当前用户是否被锁定
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
