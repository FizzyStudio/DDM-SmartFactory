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
 * 工序表Entity
 * @author gzm
 * @version 2019-06-15
 */
@Table(name="sf_work_procedure", alias="a", columns={
		@Column(name="procedure_id", attrName="procedureId", label="procedure_id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="describe", attrName="describe", label="describe"),
	}, orderBy="a.procedure_id DESC"
)
public class WorkProcedure extends DataEntity<WorkProcedure> {
	
	private static final long serialVersionUID = 1L;
	private Long procedureId;		// procedure_id
	private String name;		// name
	private String describe;		// describe
	
	public WorkProcedure() {
		this(null);
	}

	public WorkProcedure(String id){
		super(id);
	}
	
	public Long getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Long procedureId) {
		this.procedureId = procedureId;
	}
	
	@Length(min=0, max=200, message="name长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=500, message="describe长度不能超过 500 个字符")
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}