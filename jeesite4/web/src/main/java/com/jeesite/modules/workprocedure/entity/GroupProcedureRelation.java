/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 工序组-工序关系表Entity
 * @author gzm
 * @version 2019-06-23
 */
@Table(name="sf_group_procedure_relation", alias="a", columns={
		@Column(name="relation_id", attrName="relationId", label="relation_id", isPK=true),
		@Column(name="group_id", attrName="groupId", label="group_id"),
		@Column(name="procedure_id", attrName="procedureId", label="procedure_id"),
		@Column(name="step", attrName="step", label="工序步骤"),
		@Column(name="necessary_flag", attrName="necessaryFlag", label="是否必要"),
	}, orderBy="a.relation_id DESC"
)
public class GroupProcedureRelation extends DataEntity<GroupProcedureRelation> {
	
	private static final long serialVersionUID = 1L;
	private Long relationId;		// relation_id
	private Long groupId;		// group_id
	private Long procedureId;		// procedure_id
	private Integer step;		// 工序步骤
	private Integer necessaryFlag;		// 是否必要
	
	public GroupProcedureRelation() {
		this(null);
	}

	public GroupProcedureRelation(String id){
		super(id);
	}
	
	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	public Long getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Long procedureId) {
		this.procedureId = procedureId;
	}
	
	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}
	
	public Integer getNecessaryFlag() {
		return necessaryFlag;
	}

	public void setNecessaryFlag(Integer necessaryFlag) {
		this.necessaryFlag = necessaryFlag;
	}
	
}