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
 * 产品管理Entity
 * @author gzm
 * @version 2019-06-09
 */
@Table(name="sf_product_type", alias="a", columns={
		@Column(name="product_tid", attrName="productTid", label="product_tid", isPK=true),
		@Column(name="descripe", attrName="descripe", label="型号描述"),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
	}, orderBy="a.product_tid DESC"
)
public class ProductType extends DataEntity<ProductType> {
	
	private static final long serialVersionUID = 1L;
	private Long productTid;		// product_tid
	private String descripe;		// 型号描述
	private String name;		// 名称
	
	public ProductType() {
		this(null);
	}

	public ProductType(String id){
		super(id);
	}
	
	public Long getProductTid() {
		return productTid;
	}

	public void setProductTid(Long productTid) {
		this.productTid = productTid;
	}
	
	@Length(min=0, max=500, message="型号描述长度不能超过 500 个字符")
	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}
	
	@Length(min=0, max=500, message="名称长度不能超过 500 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}