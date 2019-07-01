/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.workprocedure.entity.GroupProcedureRelation;
import com.jeesite.modules.workprocedure.dao.GroupProcedureRelationDao;

/**
 * 工序组-工序关系表Service
 * @author gzm
 * @version 2019-06-23
 */
@Service
@Transactional(readOnly=true)
public class GroupProcedureRelationService extends CrudService<GroupProcedureRelationDao, GroupProcedureRelation> {
	
	/**
	 * 获取单条数据
	 * @param groupProcedureRelation
	 * @return
	 */
	@Override
	public GroupProcedureRelation get(GroupProcedureRelation groupProcedureRelation) {
		return super.get(groupProcedureRelation);
	}
	
	/**
	 * 查询分页数据
	 * @param groupProcedureRelation 查询条件
	 * @param groupProcedureRelation.page 分页对象
	 * @return
	 */
	@Override
	public Page<GroupProcedureRelation> findPage(GroupProcedureRelation groupProcedureRelation) {
		return super.findPage(groupProcedureRelation);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param groupProcedureRelation
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(GroupProcedureRelation groupProcedureRelation) {
		super.save(groupProcedureRelation);
	}
	
	/**
	 * 更新状态
	 * @param groupProcedureRelation
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(GroupProcedureRelation groupProcedureRelation) {
		super.updateStatus(groupProcedureRelation);
	}
	
	/**
	 * 删除数据
	 * @param groupProcedureRelation
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(GroupProcedureRelation groupProcedureRelation) {
		super.delete(groupProcedureRelation);
	}
	
}