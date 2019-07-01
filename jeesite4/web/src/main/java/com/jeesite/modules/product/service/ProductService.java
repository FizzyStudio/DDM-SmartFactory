/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.product.entity.Product;
import com.jeesite.modules.product.dao.ProductDao;

/**
 * 产品信息Service
 * @author gzm
 * @version 2019-06-09
 */
@Service
@Transactional(readOnly=true)
public class ProductService extends CrudService<ProductDao, Product> {
	
	/**
	 * 获取单条数据
	 * @param product
	 * @return
	 */
	@Override
	public Product get(Product product) {
		return super.get(product);
	}
	
	/**
	 * 查询分页数据
	 * @param product 查询条件
	 * @param product.page 分页对象
	 * @return
	 */
	@Override
	public Page<Product> findPage(Product product) {
		return super.findPage(product);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param product
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Product product) {
		super.save(product);
	}
	
	/**
	 * 更新状态
	 * @param product
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Product product) {
		super.updateStatus(product);
	}
	
	/**
	 * 删除数据
	 * @param product
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Product product) {
		super.delete(product);
	}
	
}