package com.xdf.utils; 

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/** 
 * BeanUtil �������ԱȽϹ����� 
 * @author zzg 
 *  
 **/ 
public class BeanUtil { 

	/**
	 * �������ʵ�������ظö�����������Թ��ɵ�Field[]����
	 * ������������
	 */
	public static Field[] getAllFields(Object object) {
	    Class clazz = object.getClass();
	    List<Field> fieldList = new ArrayList<>();
	    while (clazz != null) {
	        fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
	        clazz = clazz.getSuperclass();
	    }
	    Field[] fields = new Field[fieldList.size()];
	    fieldList.toArray(fields);
	    return fields;
	}
	
	/**
	 * ��������Ա�����ֵ�������ͬ���γ��ַ������أ�
	 * ֵ��ͬ���������� = ǰһ�������ֵ����һ�������ֵ
	 * �����ؿ��ַ���ʱ��ʾ����������������Ե����ݶ���ͬ
	 */
	public static StringBuilder compareContract(Object r1, Object r2) {
	    StringBuilder stringBuilder = new StringBuilder();
	    try {
	        Field[] fields = getAllFields(r1);
	        for (int j = 0; j < fields.length; j++) {
	            fields[j].setAccessible(true);
	            // �ֶ�ֵ
	            if (!fields[j].get(r1).equals(fields[j].get(r2))) {
	                stringBuilder.append(fields[j].getName() + "=" + fields[j].get(r1).toString() 
	                		+ "," + fields[j].get(r2).toString());
	                stringBuilder.append(System.getProperty("line.separator"));
	            }
	        }
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    }
	    return stringBuilder;
	}
	
	/*
	public static void main(String[] args) {
		Continuous continuous = new Continuous();
		continuous.setIncreament(12);
		continuous.setPrepart("ABCC1");
		continuous.setSid("120006");
		continuous.setSuffix("chanchaw");
		
		
		Continuous continuous01 = new Continuous();
		continuous01.setIncreament(11);
		continuous01.setPrepart("ABCC");
		continuous01.setSid("120006");
		continuous01.setSuffix("chanchaw");
		
//		Field[] fields= BeanUtil.getAllFields(continuous);
//		for (Field field : fields) {
//			System.out.println(field.getName());
//		}
		
		System.out.println(BeanUtil.compareContract(continuous, continuous01));
	}
	*/
    
}

