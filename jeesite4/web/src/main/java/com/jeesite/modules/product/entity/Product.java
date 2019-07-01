/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 产品信息Entity
 * @author gzm
 * @version 2019-06-09
 */
@Table(name="sf_product", alias="a", columns={
		@Column(name="product_id", attrName="productId", label="product_id", isPK=true),
		@Column(name="product_tid", attrName="productTid", label="product_tid"),
		@Column(name="qr_code", attrName="qrCode", label="二维码"),
		@Column(name="descripe", attrName="descripe", label="产品描述"),
		@Column(name="produce_plan_item_id", attrName="producePlanItemId", label="produce_plan_item_id"),
		@Column(name="produce_plan_id", attrName="producePlanId", label="produce_plan_id"),
		@Column(name="num", attrName="num", label="数量", comment="数量（默认1）"),
	}, orderBy="a.product_id DESC"
)
public class Product extends DataEntity<Product> {
	
	private static final long serialVersionUID = 1L;
	private Long productId;		// product_id
	private Long productTid;		// product_tid
	private String qrCode;		// 二维码
	private String descripe;		// 产品描述
	private Long producePlanItemId;		// produce_plan_item_id
	private Long producePlanId;		// produce_plan_id
	private Long num;		// 数量（默认1）
	
	public Product() {
		this(null);
	}

	public Product(String id){
		super(id);
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getProductTid() {
		return productTid;
	}

	public void setProductTid(Long productTid) {
		this.productTid = productTid;
	}
	
	@Length(min=0, max=2000, message="二维码长度不能超过 2000 个字符")
	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
	@Length(min=0, max=500, message="产品描述长度不能超过 500 个字符")
	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
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
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}