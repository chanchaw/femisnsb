/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  NzTree.java   
 * @Package com.xdf.utils   
 * @Description: 将DB中的数据集合转换为用父子关系的树形结构，返回ng-zorro-antd的树形类型   
 * @author: chanchaw
 * @date:   2018年12月6日 下午1:53:21   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
  * 注意：常熟市新东方智能化系统工程有限公司
 */
package com.xdf.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.ResolverUtil.Test;

import com.xdf.femisnsb.model.ContactCategory;
import com.xdf.femisnsb.model.FinishedProductCategory;
import com.xdf.femisnsb.model.NzTreeNode;

public class NzTree {
	private String idGetter;
	private String textGetter;
	private String parentIdGetter;
	private Class clz;
	private Object object;
	private Method methodId;
	private Method methodText;
	private Method methodParentid;
	
	private NzTree() {}
	
	public <T> NzTree(Class<T> clz,
			String idGetter,String textGetter,String parentIdGetter) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		this.clz=clz;
		this.idGetter=idGetter;
		this.textGetter=textGetter;
		this.parentIdGetter=parentIdGetter;
		
		this.object=clz.newInstance();
		methodId=object.getClass().getDeclaredMethod(idGetter);
		methodText=object.getClass().getDeclaredMethod(textGetter);
		methodParentid=object.getClass().getDeclaredMethod(parentIdGetter);
		/*
		 * 	调用方法：
		 * 	Object obj = methodText.invoke(实体对象);
		 */
	}
	
	

	
	
	/*
	 * 下面是测试代码，在2018年12月6日 14:40:03测试通过
	 
		private static void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
			NzTree n = new NzTree(ContactCategory.class,"getId","getName","getPid");
			ContactCategory obj = new ContactCategory();
			obj.setId(111);
			obj.setName("chanchaw");
			obj.setPid(222);
			System.out.println(n.methodText.invoke(obj).toString());
		}
		
		public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
			test();
		}
	*/
}
