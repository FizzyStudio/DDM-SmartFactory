/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.product.entity.Product;

/**
 * 产品信息DAO接口
 * @author gzm
 * @version 2019-06-09
 */
@MyBatisDao
public interface ProductDao extends CrudDao<Product> {
	
}