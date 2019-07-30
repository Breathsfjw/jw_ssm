package it.cast.jiewen.web.dao;

import it.cast.jiewen.web.domain.Orders;
import it.cast.jiewen.web.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("select * from product where id=#{id}")
    public  Product findByid(String id) throws Exception;
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product)throws Exception;
}
