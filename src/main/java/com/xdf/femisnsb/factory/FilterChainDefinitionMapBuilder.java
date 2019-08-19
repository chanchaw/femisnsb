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
		 * ʵ�ʿ����������Ǵ����ݿ��ȡ��������
		 * ����Ϊ����ʾʹ��Ӳ�������ʽ����
		 
		map.put("/ng/**","anon");//���е�¼�����ҳ��������������
		map.put("/user/login","anon");//������������
		map.put("/user/logout","logout");//ָ����¼����
		//map.put("/**","authc");// �������������������Դ��Ҫ����֤
		*/
		
//		map.put("/user/login", "anon");
		logger.info("�����ݿ��ȡ��url���ʲ����ǣ�");
		logger.info(map.toString());
		return map;
	}
}
