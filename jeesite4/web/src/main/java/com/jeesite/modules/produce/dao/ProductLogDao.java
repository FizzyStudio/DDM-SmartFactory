/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.produce.entity.ProductLog;

/**
 * 生产日志DAO接口
 * @author gzm
 * @version 2019-06-16
 */
@MyBatisDao
public interface ProductLogDao extends CrudDao<ProductLog> {
	
}