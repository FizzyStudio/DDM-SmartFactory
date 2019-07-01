/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.workprocedure.entity.GroupProcedureRelation;

/**
 * 工序组-工序关系表DAO接口
 * @author gzm
 * @version 2019-06-23
 */
@MyBatisDao
public interface GroupProcedureRelationDao extends CrudDao<GroupProcedureRelation> {
	
}