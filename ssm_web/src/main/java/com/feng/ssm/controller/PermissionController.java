package com.feng.ssm.controller;


import com.feng.ssm.domain.Permission;
import com.feng.ssm.domain.Product;
import com.feng.ssm.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;


    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN", "SYSTEM"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        Permission permission=  permissionService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("permission-show");
        mv.addObject("permission",permission);
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";

    }

    @RequestMapping("/deletePermission")
    public String deletePermission(String id) throws Exception {
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }

}


