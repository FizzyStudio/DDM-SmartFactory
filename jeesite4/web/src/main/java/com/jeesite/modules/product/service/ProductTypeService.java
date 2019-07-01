/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.product.entity.ProductType;
import com.jeesite.modules.product.dao.ProductTypeDao;

/**
 * 产品管理Service
 * @author gzm
 * @version 2019-06-09
 */
@Service
@Transactional(readOnly=true)
public class ProductTypeService extends CrudService<ProductTypeDao, ProductType> {
	
	/**
	 * 获取单条数据
	 * @param productType
	 * @return
	 */
	@Override
	public ProductType get(ProductType productType) {
		return super.get(productType);
	}
	
	/**
	 * 查询分页数据
	 * @param productType 查询条件
	 * @param productType.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProductType> findPage(ProductType productType) {
		return super.findPage(productType);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param productType
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProductType productType) {
		super.save(productType);
	}
	
	/**
	 * 更新状态
	 * @param productType
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProductType productType) {
		super.updateStatus(productType);
	}
	
	/**
	 * 删除数据
	 * @param productType
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProductType productType) {
		super.delete(productType);
	}
	
}