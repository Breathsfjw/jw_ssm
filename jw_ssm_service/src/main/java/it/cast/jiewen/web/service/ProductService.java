package it.cast.jiewen.web.service;

import it.cast.jiewen.web.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductService {
    @Select("select *from Product")
    public List<Product> findAll() throws Exception;

    public  void save(Product product) throws Exception;
}