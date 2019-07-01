/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
import com.jeesite.modules.workprocedure.entity.ProcedureGroup;
import com.jeesite.modules.workprocedure.service.ProcedureGroupService;

/**
 * 工序组Controller
 * @author gzm
 * @version 2019-06-16
 */
@Controller
@RequestMapping(value = "${adminPath}/workprocedure/procedureGroup")
public class ProcedureGroupController extends BaseController {

	@Autowired
	private ProcedureGroupService procedureGroupService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ProcedureGroup get(String procedureGroupId, boolean isNewRecord) {
		return procedureGroupService.get(procedureGroupId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(ProcedureGroup procedureGroup, Model model) {
		model.addAttribute("procedureGroup", procedureGroup);
		return "modules/workprocedure/procedureGroupList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ProcedureGroup> listData(ProcedureGroup procedureGroup, HttpServletRequest request, HttpServletResponse response) {
		procedureGroup.setPage(new Page<>(request, response));
		Page<ProcedureGroup> page = procedureGroupService.findPage(procedureGroup);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(ProcedureGroup procedureGroup, Model model) {
		model.addAttribute("procedureGroup", procedureGroup);
		return "modules/workprocedure/procedureGroupForm";
	}

	/**
	 * 保存工序组
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ProcedureGroup procedureGroup) {
		procedureGroupService.save(procedureGroup);
		return renderResult(Global.TRUE, text("保存工序组成功！"));
	}
	
	/**
	 * 删除工序组
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ProcedureGroup procedureGroup) {
		procedureGroupService.delete(procedureGroup);
		return renderResult(Global.TRUE, text("删除工序组成功！"));
	}


	@ApiOperation("增加工序至工序组")
	@PostMapping("addGroupMember")
	@ResponseBody
	public String addGroupMember() {
		return renderResult(Global.TRUE, text("增加工序至工序组成功！"));
	}

	@ApiOperation("从工序组删除成员")
	@PostMapping("deleteGroupMember")
	@ResponseBody
	public String deleteGroupMember() {
		return null;
	}

	@ApiOperation("工序组成员顺序调整")
	@PostMapping("swapMemberOrder")
	@ResponseBody
	public String swapMemberOrder() {
		return null;
	}

	@ApiOperation("获取工序详情")
	@PostMapping("getMemberDetail")
	@ResponseBody
	public String getMemberDetail() {
		return null;
	}
	
}