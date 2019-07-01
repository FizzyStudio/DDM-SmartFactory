/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.workprocedure.entity.ProcedureGroup;
import com.jeesite.modules.workprocedure.dao.ProcedureGroupDao;

/**
 * 工序组Service
 * @author gzm
 * @version 2019-06-16
 */
@Service
@Transactional(readOnly=true)
public class ProcedureGroupService extends CrudService<ProcedureGroupDao, ProcedureGroup> {
	
	/**
	 * 获取单条数据
	 * @param procedureGroup
	 * @return
	 */
	@Override
	public ProcedureGroup get(ProcedureGroup procedureGroup) {
		return super.get(procedureGroup);
	}
	
	/**
	 * 查询分页数据
	 * @param procedureGroup 查询条件
	 * @param procedureGroup.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProcedureGroup> findPage(ProcedureGroup procedureGroup) {
		return super.findPage(procedureGroup);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param procedureGroup
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProcedureGroup procedureGroup) {
		super.save(procedureGroup);
	}
	
	/**
	 * 更新状态
	 * @param procedureGroup
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProcedureGroup procedureGroup) {
		super.updateStatus(procedureGroup);
	}
	
	/**
	 * 删除数据
	 * @param procedureGroup
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProcedureGroup procedureGroup) {
		super.delete(procedureGroup);
	}
	
}