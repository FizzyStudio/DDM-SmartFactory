/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 工序组Entity
 * @author gzm
 * @version 2019-06-16
 */
@Table(name="sf_procedure_group", alias="a", columns={
		@Column(name="procedure_group_id", attrName="procedureGroupId", label="procedure_group_id", isPK=true),
		@Column(name="status", attrName="status", label="工序组状态", isUpdate=false, isQuery=false),
		@Column(name="name", attrName="name", label="工序组名称", queryType=QueryType.LIKE),
		@Column(name="descripe", attrName="descripe", label="描述"),
	}, orderBy="a.procedure_group_id DESC"
)
public class ProcedureGroup extends DataEntity<ProcedureGroup> {
	
	private static final long serialVersionUID = 1L;
	private Long procedureGroupId;		// procedure_group_id
	private String name;		// 工序组名称
	private String descripe;		// 描述
	
	public ProcedureGroup() {
		this(null);
	}

	public ProcedureGroup(String id){
		super(id);
	}
	
	public Long getProcedureGroupId() {
		return procedureGroupId;
	}

	public void setProcedureGroupId(Long procedureGroupId) {
		this.procedureGroupId = procedureGroupId;
	}
	
	@Length(min=0, max=200, message="工序组名称长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=500, message="描述长度不能超过 500 个字符")
	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}
	
}