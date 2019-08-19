package com.xdf.femisnsb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.JsonData;
import com.xdf.femisnsb.model.PermRoleUser;
import com.xdf.femisnsb.model.PermRoleUserFull;
import com.xdf.femisnsb.model.PermUser;
import com.xdf.femisnsb.model.PermUserPermission;
import com.xdf.femisnsb.service.PermUserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.HostUnauthorizedException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class PermUserController extends ExceptionHandlerController {
	private static Logger logger = LoggerFactory.getLogger(PermUserController.class);

	@Autowired
	private PermUserServiceImpl service;
	
	@ResponseBody
	@PostMapping("/insert")
	public int insert(@RequestBody PermUser instance) {
		return service.insert(instance);
	}
	
	@ResponseBody
	@GetMapping("/deleteByPrimaryKey/{id}")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimary(id);
	}
	
	@ResponseBody
	@GetMapping("/deleteByUserid/{userId}")
	public int deleteByUserid(@PathVariable("userId") String userId) {
		return service.deleteByUserid(userId);
	}
	
	@ResponseBody
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermUser instance) {
		return service.updateByPrimaryKey(instance);
	}
	
	@ResponseBody
	@GetMapping("/getByUserid/{userId}")
	public List<PermUser> getByUserid(@PathVariable("userId") String userId){
		return service.getByUserid(userId);
	}
	
	@ResponseBody
	@GetMapping("/getAll")
	public List<PermUser> getAll(){
		return service.getAll();
	}
	
	@ResponseBody
	@GetMapping("/getAllValid")
	public List<PermUser> getAllValid(){
		return service.getAllValid();
	}
	
	@ResponseBody
	@GetMapping("/getAllInvalid")
	public List<PermUser> getAllInvalid(){
		return service.getAllInvalid();
	}
	
	
	@ResponseBody
	@GetMapping("/getRolesById/{id}")
	public List<PermRoleUser> getRolesById(@PathVariable("id") Integer id){
		return service.getRolesById(id);
	}
	
	@ResponseBody
	@GetMapping("/getRolesByUserId/{userId}")
	public List<PermRoleUser> getRolesByUserId(@PathVariable("userId") String userId){
		return service.getRolesByUserId(userId);
	}
	
	@ResponseBody
	@GetMapping("/getAclsById/{id}")
	public List<PermUserPermission> getAclsById(@PathVariable("id") Integer id){
		return service.getAclsById(id);
	}
	
	@ResponseBody
	@GetMapping("/getAclsByUserId/{userId}")
	public List<PermUserPermission> getAclsByUserId(@PathVariable("userId") String userId){
		return service.getAclsByUserId(userId);
	}
	
	@ResponseBody
	@GetMapping("/login/{userid}/{password}")
	public JsonData login(@PathVariable("userid") String userid,
		@PathVariable("password") String password) {
		JsonData jsonData =service.login(userid, password);
		return jsonData;
	}
	

	@ResponseBody
	@GetMapping("/isLogined")
	public boolean isLogined() {
		logger.info("PermUserController#isLogined,this is entery!");
		boolean is = false;
		
		Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole("admin")) {
			logger.info("当前用户有角色：admin");
		}else {
			logger.info("当前用户没有角色：admin");
		}
		
		try {
			is = service.isLogined();
		} catch (HostUnauthorizedException e1) {
			logger.info("HostUnauthorizedException");
			throw new RuntimeException("HostUnauthorizedException");
		} catch (UnauthorizedException e2) {
			logger.info("UnauthorizedException");
			throw new RuntimeException("UnauthorizedException");
		} catch (UnauthenticatedException e3) {
			logger.info("UnauthenticatedException");
			throw new RuntimeException("UnauthenticatedException");			
		} catch (AuthorizationException e4) {
			logger.info("AuthorizationException");
			throw new RuntimeException("AuthorizationException");
		} catch (Exception e) {
			logger.info("*****************验证登录时出现异常！");
			throw new RuntimeException("Exception");
		}
		
		
		logger.info("PermUserController#isLogined 没有出现异常！");
		logger.info("PermUserController#isLogined：" + is);
		return is;
	}
	

	@ResponseBody
	@GetMapping("/logout")
	public PermUser logout() {
		service.logout();
		
		PermUser user = new PermUser();
		user.setId(1);
		user.setUsername("测试登出");
		return user;
	}
	
	
	@ResponseBody
	@RequestMapping("/noPermissionHandler")
	public JsonData noPermissionHandler() {
		logger.info("PermUserController#noPermissionHandler");
		return JsonData.fail("您没有权限执行该操作！");
	}
	
	@ResponseBody
	@RequestMapping("/getChildrenUsers/{roleId}")
	public List<PermRoleUserFull> getChildrenUsers(@PathVariable("roleId") Integer roleId){
		return service.getChildrenUsers(roleId);
	}
}
