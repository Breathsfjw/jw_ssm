package it.cast.jiewen.web.controller;

import it.cast.jiewen.web.domain.Permission;
import it.cast.jiewen.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    /*****************查询所有权限************/
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        List<Permission> permissionList=permissionService.findAll();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }
    /*****************添加权限************/
    @RequestMapping("/save")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
