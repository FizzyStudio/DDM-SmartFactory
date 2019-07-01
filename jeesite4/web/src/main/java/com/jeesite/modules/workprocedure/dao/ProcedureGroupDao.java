/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.workprocedure.entity.ProcedureGroup;

/**
 * 工序组DAO接口
 * @author gzm
 * @version 2019-06-16
 */
@MyBatisDao
public interface ProcedureGroupDao extends CrudDao<ProcedureGroup> {
	
}