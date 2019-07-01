/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.produce.entity.ProducePlanItem;
import com.jeesite.modules.produce.dao.ProducePlanItemDao;

/**
 * 计划明细Service
 * @author gzm
 * @version 2019-06-16
 */
@Service
@Transactional(readOnly=true)
public class ProducePlanItemService extends CrudService<ProducePlanItemDao, ProducePlanItem> {
	
	/**
	 * 获取单条数据
	 * @param producePlanItem
	 * @return
	 */
	@Override
	public ProducePlanItem get(ProducePlanItem producePlanItem) {
		return super.get(producePlanItem);
	}
	
	/**
	 * 查询分页数据
	 * @param producePlanItem 查询条件
	 * @param producePlanItem.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProducePlanItem> findPage(ProducePlanItem producePlanItem) {
		return super.findPage(producePlanItem);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param producePlanItem
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProducePlanItem producePlanItem) {
		super.save(producePlanItem);
	}
	
	/**
	 * 更新状态
	 * @param producePlanItem
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProducePlanItem producePlanItem) {
		super.updateStatus(producePlanItem);
	}
	
	/**
	 * 删除数据
	 * @param producePlanItem
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProducePlanItem producePlanItem) {
		super.delete(producePlanItem);
	}
	
}