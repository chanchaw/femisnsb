package com.xdf.femisnsb.factory;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdf.femisnsb.model.PermUrlStrategy;
import com.xdf.femisnsb.service.PermUrlStrategyServiceImpl;

@Service
public class FilterChainDefinitionMapBuilder {
	
	private static Logger logger = LoggerFactory.getLogger(FilterChainDefinitionMapBuilder.class);
	
	@Autowired
	private PermUrlStrategyServiceImpl service;
	
	public LinkedHashMap<String, String> buildMap(){
		LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
		
		List<PermUrlStrategy> list = service.getAll();
		if(list != null && list.size()>0) {
			for (PermUrlStrategy permUrlStrategy : list) {
				map.put(permUrlStrategy.getUrl(), permUrlStrategy.getShirointerceptor());
			}
		}
		
		/*
		 * 实际开发中这里是从数据库获取配置数据
		 * 这里为了演示使用硬编码的形式配置
		 
		map.put("/ng/**","anon");//带有登录框的首页，可以匿名访问
		map.put("/user/login","anon");//可以匿名访问
		map.put("/user/logout","logout");//指定登录请求
		//map.put("/**","authc");// 除了上面的配置其他资源都要求认证
		*/
		
//		map.put("/user/login", "anon");
		logger.info("从数据库获取的url访问策略是：");
		logger.info(map.toString());
		return map;
	}
}
