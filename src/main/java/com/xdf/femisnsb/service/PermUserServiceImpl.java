package com.xdf.femisnsb.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PermUserMapper;
import com.xdf.femisnsb.model.JsonData;
import com.xdf.femisnsb.model.PermRoleUser;
import com.xdf.femisnsb.model.PermRoleUserFull;
import com.xdf.femisnsb.model.PermUser;
import com.xdf.femisnsb.model.PermUserPermission;

@Service
public class PermUserServiceImpl implements PermUserService {

	private static Logger logger = LoggerFactory.getLogger(PermUserServiceImpl.class);
	
	@Autowired
	private PermUserMapper dao;
	
	public int insert(PermUser instance) {
		return dao.insert(instance);
	}

	public int deleteByPrimary(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int deleteByUserid(String userId) {
		List<PermUser> list = dao.selectByUserid(userId);
		for (PermUser permUser : list) {
			dao.deleteByPrimaryKey(permUser.getId());
		}
		return list.size();
	}

	public int updateByPrimaryKey(PermUser instance) {
		return dao.updateByPrimaryKey(instance);
	}

	public PermUser getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermUser> getByUserid(String userId) {
		return dao.selectByUserid(userId);
	}

	public List<PermUser> getAll() {
		System.out.println("PermUserServiceImpl#getAll");
		List<PermUser> list = null;
		try {
			list = dao.selectAll();
		} catch (Exception e) {
			System.out.println("在PermUserServiceImpl#getAll中出现异常");
			System.out.println(dao);
		}
		System.out.println("查询获取到的数据是：");
		System.out.println(list.toString());
		return list;
	}

	public List<PermUser> getAllValid() {
		List<PermUser> list = dao.selectAllValid(); 
		return list;
	}

	public List<PermUser> getAllInvalid() {
		return dao.selectAllInvalid();
	}

	public List<PermRoleUser> getRolesById(Integer id) {
		return dao.selectRolesById(id);
	}

	public List<PermRoleUser> getRolesByUserId(String userId) {
		return dao.selectRolesByUserId(userId);
	}

	public List<PermUserPermission> getAclsById(Integer id) {
		return dao.selectAclsById(id);
	}

	public List<PermUserPermission> getAclsByUserId(String userId) {
		return dao.selectAclsByUserId(userId);
	}

	// 登录
	public JsonData login(String userid, String password) {
		logger.info("enter method");
		System.out.println("进入PermUserServiceImpl#login，传入的密码是：" + password);
		
		Subject currentUser = SecurityUtils.getSubject();
		logger.info("by SecurityUtils.getSubject() the result is:" + currentUser.toString());
		
		if(!currentUser.isAuthenticated()) {
			logger.info("isAuthenticated=false,begin authenticate!");
			System.out.println("!currentUser.isAuthenticated() 之后");
			
			UsernamePasswordToken token = new UsernamePasswordToken(userid,password);
			token.setRememberMe(true);
			try {
				logger.info("enter try block");
				currentUser.login(token);
				logger.info("authenticate success!");
			} catch (UnknownAccountException e0) {
				logger.info("account not exist");
				JsonData jd = JsonData.fail("账号不存在！"); 
				logger.info("upcoming return JsonData is :" + jd);
				return jd;

			} catch (IncorrectCredentialsException e1) {
				logger.info("password error!");
				JsonData jd = JsonData.fail("密码错误！");
				logger.info("upcoming return JsonData is :" + jd);
				return jd;
			} catch(LockedAccountException e2) {
				logger.info("account is locaked!");
				JsonData jd = JsonData.fail("账号被锁定！");
				logger.info("upcoming return JsonData is :" + jd);
				return jd;
				
			} catch (AccountException e3) {
				logger.info("AccountException");
				JsonData jd = JsonData.fail("账号异常！");
				logger.info("upcoming return JsonData is :" + jd);
				return jd;	
			} catch(CredentialsException e4) {
				logger.info("CredentialsException");
				JsonData jd = JsonData.fail("凭证异常！");
				logger.info("upcoming return JsonData is :" + jd);
				return jd;	
			} catch(UnsupportedTokenException e5) {
				logger.info("UnsupportedTokenException");
				JsonData jd = JsonData.fail("不支持的token异常");
				logger.info("upcoming return JsonData is :" + jd);
				return jd;		
			} catch (AuthenticationException e6) {
				logger.info("AuthenticationException");
				JsonData jd = JsonData.fail("未知的登录异常！");
				logger.info("upcoming return JsonData is :" + jd);
				return jd;
			}
		}
		
		JsonData jd = JsonData.success(currentUser,"success");
		logger.info("upcoming return JsonData:" + jd.toString());
		return jd;
	}
	
	
	
	@RequiresRoles({"admin"})
	public boolean isLogined() {
		logger.info("进入方法内");
		boolean logined = SecurityUtils.getSubject().isAuthenticated();
		logger.info("SecurityUtils.getSubject().isAuthenticated()获取的认证状态是：" + logined);
		
		return logined;
	}
	
	public String logout() {
		System.out.println("PermUserServiceImpl#logout");
		
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()) {
			System.out.println("即将执行注销");
			try {
				currentUser.logout();
				System.out.println("注销完毕！");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		
		System.out.println("PermUserServiceImpl#logout:即将return!");
		return "hello"; 
	}

	public List<PermRoleUserFull> getChildrenUsers(Integer roleId) {
		return dao.selectChildrenUsers(roleId);
	}

}
