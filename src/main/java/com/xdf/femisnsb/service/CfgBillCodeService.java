package com.xdf.femisnsb.service;

import com.xdf.femisnsb.model.CfgBillCode;

/**   
 * @ClassName:  CfgBillCodeService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����3:30:28   
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
