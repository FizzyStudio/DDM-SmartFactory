/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.workprocedure.entity.WorkProcedure;
import com.jeesite.modules.workprocedure.dao.WorkProcedureDao;

/**
 * 工序表Service
 * @author gzm
 * @version 2019-06-15
 */
@Service
@Transactional(readOnly=true)
public class WorkProcedureService extends CrudService<WorkProcedureDao, WorkProcedure> {
	
	/**
	 * 获取单条数据
	 * @param workProcedure
	 * @return
	 */
	@Override
	public WorkProcedure get(WorkProcedure workProcedure) {
		return super.get(workProcedure);
	}
	
	/**
	 * 查询分页数据
	 * @param workProcedure 查询条件
	 * @param workProcedure.page 分页对象
	 * @return
	 */
	@Override
	public Page<WorkProcedure> findPage(WorkProcedure workProcedure) {
		return super.findPage(workProcedure);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param workProcedure
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WorkProcedure workProcedure) {
		super.save(workProcedure);
	}
	
	/**
	 * 更新状态
	 * @param workProcedure
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WorkProcedure workProcedure) {
		super.updateStatus(workProcedure);
	}
	
	/**
	 * 删除数据
	 * @param workProcedure
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WorkProcedure workProcedure) {
		super.delete(workProcedure);
	}
	
}