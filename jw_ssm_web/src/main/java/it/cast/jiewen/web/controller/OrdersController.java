package it.cast.jiewen.web.controller;

import com.github.pagehelper.PageInfo;
import it.cast.jiewen.web.domain.Orders;
import it.cast.jiewen.web.domain.Product;
import it.cast.jiewen.web.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    /**********未分页*********/
    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList=ordersService.findAll();
        System.out.println(ordersList);
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/
    /**********分页订单查询*********/
       @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,@RequestParam(name = "size",defaultValue = "4",required = true)Integer size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList=ordersService.findAll(page,size);
           PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    /**********订单详情查询*********/
    @RequestMapping("/findByid.do")
    public ModelAndView findByid(@RequestParam(name = "id",required = true)String id) throws Exception{
        ModelAndView mv=new ModelAndView();
        System.out.println("a");
        Orders orders=ordersService.findByid(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
