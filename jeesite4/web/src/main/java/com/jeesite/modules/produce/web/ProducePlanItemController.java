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
import com.jeesite.modules.produce.entity.ProducePlanItem;
import com.jeesite.modules.produce.service.ProducePlanItemService;

/**
 * 计划明细Controller
 * @author gzm
 * @version 2019-06-16
 */
@Controller
@RequestMapping(value = "${adminPath}/produce/producePlanItem")
public class ProducePlanItemController extends BaseController {

	@Autowired
	private ProducePlanItemService producePlanItemService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProducePlanItem get(String producePlanItemId, boolean isNewRecord) {
		return producePlanItemService.get(producePlanItemId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("produce:producePlanItem:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProducePlanItem producePlanItem, Model model) {
		model.addAttribute("producePlanItem", producePlanItem);
		return "modules/produce/producePlanItemList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("produce:producePlanItem:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProducePlanItem> listData(ProducePlanItem producePlanItem, HttpServletRequest request, HttpServletResponse response) {
		producePlanItem.setPage(new Page<>(request, response));
		Page<ProducePlanItem> page = producePlanItemService.findPage(producePlanItem);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("produce:producePlanItem:view")
	@RequestMapping(value = "form")
	public String form(ProducePlanItem producePlanItem, Model model) {
		model.addAttribute("producePlanItem", producePlanItem);
		return "modules/produce/producePlanItemForm";
	}

	/**
	 * 保存计划明细
	 */
	@RequiresPermissions("produce:producePlanItem:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProducePlanItem producePlanItem) {
		producePlanItemService.save(producePlanItem);
		return renderResult(Global.TRUE, text("保存计划明细成功！"));
	}
	
	/**
	 * 删除计划明细
	 */
	@RequiresPermissions("produce:producePlanItem:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProducePlanItem producePlanItem) {
		producePlanItemService.delete(producePlanItem);
		return renderResult(Global.TRUE, text("删除计划明细成功！"));
	}
	
}