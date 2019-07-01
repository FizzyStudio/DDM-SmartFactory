/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.produce.entity.ProducePlan;
import com.jeesite.modules.produce.dao.ProducePlanDao;

/**
 * 生产计划Service
 * @author gzm
 * @version 2019-06-16
 */
@Service
@Transactional(readOnly=true)
public class ProducePlanService extends CrudService<ProducePlanDao, ProducePlan> {
	
	/**
	 * 获取单条数据
	 * @param producePlan
	 * @return
	 */
	@Override
	public ProducePlan get(ProducePlan producePlan) {
		return super.get(producePlan);
	}
	
	/**
	 * 查询分页数据
	 * @param producePlan 查询条件
	 * @param producePlan.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProducePlan> findPage(ProducePlan producePlan) {
		return super.findPage(producePlan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param producePlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProducePlan producePlan) {
		super.save(producePlan);
	}
	
	/**
	 * 更新状态
	 * @param producePlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProducePlan producePlan) {
		super.updateStatus(producePlan);
	}
	
	/**
	 * 删除数据
	 * @param producePlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProducePlan producePlan) {
		super.delete(producePlan);
	}
	
}