package com.xdf.femisnsb.service;

import com.xdf.femisnsb.model.CfgBillCode;

/**   
 * @ClassName:  CfgBillCodeService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午3:30:28   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface CfgBillCodeService {

	int insert(CfgBillCode record);
    int deleteByPrimaryKey(String sid);
    int updateByPrimaryKey(CfgBillCode record);
    CfgBillCode getByPrimaryKey(String sid);
    String getCurPrePart(String sid);
}
