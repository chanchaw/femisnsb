package com.xdf.femisnsb.service;

import java.util.Date;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

@Service
public class ShiroService {

	@RequiresRoles({"admin"})//要求拥有角色admin才可访问本请求
	public void testShiro() {
		System.out.println("ShiroService#testShiro,Date =" + new Date());
	}
	
}
