package com.xdf.femisnsb.service;

import com.xdf.femisnsb.model.Continuous;

/**   
 * @ClassName:  ContinuousService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����10:44:56   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface ContinuousService {
	int insert(Continuous record);
    int deleteByPrimaryKey(String sid);
    int updateByPrimaryKey(Continuous record);
    Continuous getByPrimaryKey(String sid);
    Continuous getPrepartLast(String prePart);
    
    String getNewBillCode(String billSid);
    boolean isFabricBillcodeExists(String codeid);
}
