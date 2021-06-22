package com.feng.ssm.controller;


import com.feng.ssm.domain.Product;
import com.feng.ssm.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //查询所有产品信息
    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }*/

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN", "BUSINESS"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(productList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;

    }

    //产品添加
    @RequestMapping("/save.do")
    @RolesAllowed({"ADMIN", "BUSINESS"})
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";

    }
}
