/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.workprocedure.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.shiro.n.A;
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
import com.jeesite.modules.workprocedure.entity.WorkProcedure;
import com.jeesite.modules.workprocedure.service.WorkProcedureService;

/**
 * 工序表Controller
 *
 * @author gzm
 * @version 2019-06-15
 */
@Controller
@RequestMapping(value = "${adminPath}/workprocedure/workProcedure")
public class WorkProcedureController extends BaseController {

    @Autowired
    private WorkProcedureService workProcedureService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public WorkProcedure get(String procedureId, boolean isNewRecord) {
        return workProcedureService.get(procedureId, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("workprocedure:workProcedure:view")
    @RequestMapping(value = {"list", ""})
    public String list(WorkProcedure workProcedure, Model model) {
        model.addAttribute("workProcedure", workProcedure);
        return "modules/workprocedure/workProcedureList";
    }

    /**
     * 查询列表数据
     */
    @RequiresPermissions("workprocedure:workProcedure:view")
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<WorkProcedure> listData(WorkProcedure workProcedure, HttpServletRequest request, HttpServletResponse response) {
        workProcedure.setPage(new Page<>(request, response));
        Page<WorkProcedure> page = workProcedureService.findPage(workProcedure);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequiresPermissions("workprocedure:workProcedure:view")
    @RequestMapping(value = "form")
    public String form(WorkProcedure workProcedure, Model model) {
        model.addAttribute("workProcedure", workProcedure);
        return "modules/workprocedure/workProcedureForm";
    }

    /**
     * 保存工序表
     */
    @RequiresPermissions("workprocedure:workProcedure:edit")
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated WorkProcedure workProcedure) {
        workProcedureService.save(workProcedure);
        return renderResult(Global.TRUE, text("保存工序表成功！"));
    }

    /**
     * 删除工序表
     */
    @RequiresPermissions("workprocedure:workProcedure:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(WorkProcedure workProcedure) {
        workProcedureService.delete(workProcedure);
        return renderResult(Global.TRUE, text("删除工序表成功！"));
    }



}