/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.produce.entity.ProductLog;
import com.jeesite.modules.produce.dao.ProductLogDao;

/**
 * 生产日志Service
 * @author gzm
 * @version 2019-06-16
 */
@Service
@Transactional(readOnly=true)
public class ProductLogService extends CrudService<ProductLogDao, ProductLog> {
	
	/**
	 * 获取单条数据
	 * @param productLog
	 * @return
	 */
	@Override
	public ProductLog get(ProductLog productLog) {
		return super.get(productLog);
	}
	
	/**
	 * 查询分页数据
	 * @param productLog 查询条件
	 * @param productLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProductLog> findPage(ProductLog productLog) {
		return super.findPage(productLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param productLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProductLog productLog) {
		super.save(productLog);
	}
	
	/**
	 * 更新状态
	 * @param productLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProductLog productLog) {
		super.updateStatus(productLog);
	}
	
	/**
	 * 删除数据
	 * @param productLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProductLog productLog) {
		super.delete(productLog);
	}
	
}