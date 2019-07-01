/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.workprocedure.entity.WorkProcedure;

/**
 * 工序表DAO接口
 * @author gzm
 * @version 2019-06-15
 */
@MyBatisDao
public interface WorkProcedureDao extends CrudDao<WorkProcedure> {
	
}