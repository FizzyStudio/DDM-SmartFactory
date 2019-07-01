/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 生产日志Entity
 * @author gzm
 * @version 2019-06-16
 */
@Table(name="sf_product_log", alias="a", columns={
		@Column(name="product_log_id", attrName="productLogId", label="product_log_id", isPK=true),
		@Column(name="product_id", attrName="productId", label="产品"),
		@Column(name="work_seat_id", attrName="workSeatId", label="工位"),
		@Column(name="employer_id", attrName="employerId", label="员工"),
		@Column(name="procedure_id", attrName="procedureId", label="工序"),
		@Column(name="create_at", attrName="createAt", label="时间"),
		@Column(name="num", attrName="num", label="数量"),
		@Column(name="check_result", attrName="checkResult", label="检测结果"),
		@Column(name="measurement", attrName="measurement", label="检测数据"),
	}, orderBy="a.product_log_id DESC"
)
public class ProductLog extends DataEntity<ProductLog> {
	
	private static final long serialVersionUID = 1L;
	private Long productLogId;		// product_log_id
	private Long productId;		// 产品
	private Long workSeatId;		// 工位
	private Long employerId;		// 员工
	private Long procedureId;		// 工序
	private Date createAt;		// 时间
	private Long num;		// 数量
	private Integer checkResult;		// 检测结果
	private String measurement;		// 检测数据
	
	public ProductLog() {
		this(null);
	}

	public ProductLog(String id){
		super(id);
	}
	
	public Long getProductLogId() {
		return productLogId;
	}

	public void setProductLogId(Long productLogId) {
		this.productLogId = productLogId;
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getWorkSeatId() {
		return workSeatId;
	}

	public void setWorkSeatId(Long workSeatId) {
		this.workSeatId = workSeatId;
	}
	
	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	
	public Long getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Long procedureId) {
		this.procedureId = procedureId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
	public Integer getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}
	
	@Length(min=0, max=500, message="检测数据长度不能超过 500 个字符")
	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	
}