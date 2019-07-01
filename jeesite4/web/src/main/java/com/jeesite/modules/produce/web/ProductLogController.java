/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.produce.entity.ProductLog;
import com.jeesite.modules.produce.service.ProductLogService;

/**
 * 生产日志Controller
 * @author gzm
 * @version 2019-06-16
 */
@Controller
@RequestMapping(value = "${adminPath}/produce/productLog")
public class ProductLogController extends BaseController {

	@Autowired
	private ProductLogService productLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProductLog get(String productLogId, boolean isNewRecord) {
		return productLogService.get(productLogId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@ApiOperation("获取操作日志列表")
	@RequiresPermissions("produce:productLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductLog productLog, Model model) {
		model.addAttribute("productLog", productLog);
		return "modules/produce/productLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("produce:productLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProductLog> listData(ProductLog productLog, HttpServletRequest request, HttpServletResponse response) {
		productLog.setPage(new Page<>(request, response));
		Page<ProductLog> page = productLogService.findPage(productLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("produce:productLog:view")
	@RequestMapping(value = "form")
	public String form(ProductLog productLog, Model model) {
		model.addAttribute("productLog", productLog);
		return "modules/produce/productLogForm";
	}

	/**
	 * 保存生产日志
	 */
	@RequiresPermissions("produce:productLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProductLog productLog) {
		productLogService.save(productLog);
		return renderResult(Global.TRUE, text("保存生产日志成功！"));
	}
	
	/**
	 * 删除生产日志
	 */
	@RequiresPermissions("produce:productLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProductLog productLog) {
		productLogService.delete(productLog);
		return renderResult(Global.TRUE, text("删除生产日志成功！"));
	}
	
}