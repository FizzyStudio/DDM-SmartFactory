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
import com.jeesite.modules.product.entity.Product;
import com.jeesite.modules.product.service.ProductService;

/**
 * 产品信息Controller
 *
 * @author gzm
 * @version 2019-06-09
 */
@Controller
@RequestMapping(value = "${adminPath}/product/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public Product get(Long productId, boolean isNewRecord) {
        return productService.get("" + productId, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequiresPermissions("product:product:view")
    @RequestMapping(value = {"list", ""})
    public String list(Product product, Model model) {
        model.addAttribute("product", product);
        return "modules/product/productList";
    }

    /**
     * 查询列表数据
     */
    @RequiresPermissions("product:product:view")
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<Product> listData(Product product, HttpServletRequest request, HttpServletResponse response) {
        product.setPage(new Page<>(request, response));
        Page<Product> page = productService.findPage(product);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequiresPermissions("product:product:view")
    @RequestMapping(value = "form")
    public String form(Product product, Model model) {
        model.addAttribute("product", product);
        return "modules/product/productForm";
    }

    /**
     * 保存产品表
     */
    @RequiresPermissions("product:product:edit")
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated Product product) {
        productService.save(product);
        return renderResult(Global.TRUE, text("保存产品表成功！"));
    }

    /**
     * 删除产品表
     */
    @RequiresPermissions("product:product:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Product product) {
        productService.delete(product);
        return renderResult(Global.TRUE, text("删除产品表成功！"));
    }

}