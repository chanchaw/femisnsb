/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  NzTree.java   
 * @Package com.xdf.utils   
 * @Description: ��DB�е����ݼ���ת��Ϊ�ø��ӹ�ϵ�����νṹ������ng-zorro-antd����������   
 * @author: chanchaw
 * @date:   2018��12��6�� ����1:53:21   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
  * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
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
		 * 	���÷�����
		 * 	Object obj = methodText.invoke(ʵ�����);
		 */
	}
	
	

	
	
	/*
	 * �����ǲ��Դ��룬��2018��12��6�� 14:40:03����ͨ��
	 
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
