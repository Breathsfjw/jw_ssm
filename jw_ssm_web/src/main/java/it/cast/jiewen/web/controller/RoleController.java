package it.cast.jiewen.web.controller;

import it.cast.jiewen.web.domain.Role;

import it.cast.jiewen.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    /***********查询所有角色**********/
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        modelAndView.addObject("roleList", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }
}