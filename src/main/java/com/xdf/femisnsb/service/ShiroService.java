package com.xdf.femisnsb.service;

import java.util.Date;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

@Service
public class ShiroService {

	@RequiresRoles({"admin"})//Ҫ��ӵ�н�ɫadmin�ſɷ��ʱ�����
	public void testShiro() {
		System.out.println("ShiroService#testShiro,Date =" + new Date());
	}
	
}
