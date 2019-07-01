/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 生产计划Entity
 * @author gzm
 * @version 2019-06-16
 */
@Table(name="sf_produce_plan", alias="a", columns={
		@Column(name="produce_plan_id", attrName="producePlanId", label="produce_plan_id", isPK=true),
		@Column(name="name", attrName="name", label="计划名称", queryType=QueryType.LIKE),
		@Column(name="begin_time", attrName="beginTime", label="计划开始时间"),
		@Column(name="end_time", attrName="endTime", label="计划结束时间"),
		@Column(name="descripe", attrName="descripe", label="计划描述"),
		@Column(name="pid", attrName="pid", label="父id"),
		@Column(name="status", attrName="status", label="status", isUpdate=false),
	}, orderBy="a.produce_plan_id DESC"
)
public class ProducePlan extends DataEntity<ProducePlan> {
	
	private static final long serialVersionUID = 1L;
	private Long producePlanId;		// produce_plan_id
	private String name;		// 计划名称
	private Date beginTime;		// 计划开始时间
	private Date endTime;		// 计划结束时间
	private String descripe;		// 计划描述
	private Long pid;		// 父id
	
	public ProducePlan() {
		this(null);
	}

	public ProducePlan(String id){
		super(id);
	}
	
	public Long getProducePlanId() {
		return producePlanId;
	}

	public void setProducePlanId(Long producePlanId) {
		this.producePlanId = producePlanId;
	}
	
	@Length(min=0, max=200, message="计划名称长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Length(min=0, max=500, message="计划描述长度不能超过 500 个字符")
	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
	
}