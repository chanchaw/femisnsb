package com.xdf.femisnsb.service;

import com.xdf.femisnsb.model.Continuous;

/**   
 * @ClassName:  ContinuousService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午10:44:56   
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
