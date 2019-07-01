/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 计划明细Entity
 * @author gzm
 * @version 2019-06-16
 */
@Table(name="sf_produce_plan_item", alias="a", columns={
		@Column(name="produce_plan_item_id", attrName="producePlanItemId", label="produce_plan_item_id", isPK=true),
		@Column(name="produce_plan_id", attrName="producePlanId", label="生产计划"),
		@Column(name="product_tid", attrName="productTid", label="产品类型"),
		@Column(name="procedure_group_id", attrName="procedureGroupId", label="工序组"),
		@Column(name="num", attrName="num", label="数量"),
	}, orderBy="a.produce_plan_item_id DESC"
)
public class ProducePlanItem extends DataEntity<ProducePlanItem> {
	
	private static final long serialVersionUID = 1L;
	private Long producePlanItemId;		// produce_plan_item_id
	private Long producePlanId;		// 生产计划
	private Long productTid;		// 产品类型
	private Long procedureGroupId;		// 工序组
	private Long num;		// 数量
	
	public ProducePlanItem() {
		this(null);
	}

	public ProducePlanItem(String id){
		super(id);
	}
	
	public Long getProducePlanItemId() {
		return producePlanItemId;
	}

	public void setProducePlanItemId(Long producePlanItemId) {
		this.producePlanItemId = producePlanItemId;
	}
	
	public Long getProducePlanId() {
		return producePlanId;
	}

	public void setProducePlanId(Long producePlanId) {
		this.producePlanId = producePlanId;
	}
	
	public Long getProductTid() {
		return productTid;
	}

	public void setProductTid(Long productTid) {
		this.productTid = productTid;
	}
	
	public Long getProcedureGroupId() {
		return procedureGroupId;
	}

	public void setProcedureGroupId(Long procedureGroupId) {
		this.procedureGroupId = procedureGroupId;
	}
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}