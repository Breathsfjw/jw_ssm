package it.cast.jiewen.web.controller;

import it.cast.jiewen.web.domain.Product;
import it.cast.jiewen.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
/*********查询所用产品*********/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }
    /*******保存订单*******/
    @RequestMapping("/save.do")
public String  save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

}
