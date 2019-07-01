/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.produce.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.produce.entity.ProducePlan;
import com.jeesite.modules.produce.service.ProducePlanService;

/**
 * 生产计划Controller
 * @author gzm
 * @version 2019-06-16
 */
@Controller
@RequestMapping(value = "${adminPath}/produce/producePlan")
public class ProducePlanController extends BaseController {

	@Autowired
	private ProducePlanService producePlanService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProducePlan get(String producePlanId, boolean isNewRecord) {
		return producePlanService.get(producePlanId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("produce:producePlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProducePlan producePlan, Model model) {
		model.addAttribute("producePlan", producePlan);
		return "modules/produce/producePlanList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("produce:producePlan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProducePlan> listData(ProducePlan producePlan, HttpServletRequest request, HttpServletResponse response) {
		producePlan.setPage(new Page<>(request, response));
		Page<ProducePlan> page = producePlanService.findPage(producePlan);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("produce:producePlan:view")
	@RequestMapping(value = "form")
	public String form(ProducePlan producePlan, Model model) {
		model.addAttribute("producePlan", producePlan);
		return "modules/produce/producePlanForm";
	}

	/**
	 * 保存生产计划
	 */
	@RequiresPermissions("produce:producePlan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProducePlan producePlan) {
		producePlanService.save(producePlan);
		return renderResult(Global.TRUE, text("保存生产计划成功！"));
	}
	
	/**
	 * 删除生产计划
	 */
	@RequiresPermissions("produce:producePlan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProducePlan producePlan) {
		producePlanService.delete(producePlan);
		return renderResult(Global.TRUE, text("删除生产计划成功！"));
	}
	
}