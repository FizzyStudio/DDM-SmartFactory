/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.web;

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
import com.jeesite.modules.product.entity.ProductType;
import com.jeesite.modules.product.service.ProductTypeService;

/**
 * 产品管理Controller
 *
 * @author gzm
 * @version 2019-06-09
 */
@Controller
@RequestMapping(value = "${adminPath}/product/productType")
public class ProductTypeController extends BaseController {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public ProductType get(Long productTid, boolean isNewRecord) {
        return productTypeService.get("" + productTid, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("product:productType:view")
    @RequestMapping(value = {"list", ""})
    public String list(ProductType productType, Model model) {
        model.addAttribute("productType", productType);
        return "modules/product/productTypeList";
    }

    /**
     * 查询列表数据
     */
    @RequiresPermissions("product:productType:view")
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<ProductType> listData(ProductType productType, HttpServletRequest request, HttpServletResponse response) {
        productType.setPage(new Page<>(request, response));
        Page<ProductType> page = productTypeService.findPage(productType);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequiresPermissions("product:productType:view")
    @RequestMapping(value = "form")
    public String form(ProductType productType, Model model) {
        model.addAttribute("productType", productType);
        return "modules/product/productTypeForm";
    }

    /**
     * 保存产品型号信息
     */
    @RequiresPermissions("product:productType:edit")
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated ProductType productType) {
        productTypeService.save(productType);
        return renderResult(Global.TRUE, text("保存产品型号信息成功！"));
    }

    /**
     * 停用产品型号信息
     */
    @RequiresPermissions("product:productType:edit")
    @RequestMapping(value = "disable")
    @ResponseBody
    public String disable(ProductType productType) {
        productType.setStatus(ProductType.STATUS_DISABLE);
        productTypeService.updateStatus(productType);
        return renderResult(Global.TRUE, text("停用产品型号信息成功"));
    }

    /**
     * 启用产品型号信息
     */
    @RequiresPermissions("product:productType:edit")
    @RequestMapping(value = "enable")
    @ResponseBody
    public String enable(ProductType productType) {
        productType.setStatus(ProductType.STATUS_NORMAL);
        productTypeService.updateStatus(productType);
        return renderResult(Global.TRUE, text("启用产品型号信息成功"));
    }

    /**
     * 删除产品型号信息
     */
    @RequiresPermissions("product:productType:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(ProductType productType) {
        productTypeService.delete(productType);
        return renderResult(Global.TRUE, text("删除产品型号信息成功！"));
    }

}