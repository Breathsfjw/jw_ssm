package it.cast.jiewen.web.controller;

import it.cast.jiewen.web.domain.Role;
import it.cast.jiewen.web.domain.UserInfo;
import it.cast.jiewen.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /****************查询所有用户************/
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        List<UserInfo> userList=userService.findAll();
        modelAndView.addObject("userlist",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    /****************通过id查询用户************/
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String userId) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        UserInfo user=userService.findById(userId);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }
    /****************创建用户************/
    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String userId) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        UserInfo userInfo=userService.findById(userId);
      List<Role> otherRoles=userService.findotherRole(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", otherRoles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }
}
