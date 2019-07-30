package it.cast.jiewen.web.dao;

import it.cast.jiewen.web.domain.Member;
import it.cast.jiewen.web.domain.Orders;
import it.cast.jiewen.web.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrdersDao {
/************************查询全部订单**************/
  @Select("select * from orders")
  @Results({
          @Result(id = true, property = "id", column = "id"),
          @Result(property = "orderNum", column = "orderNum"),
          @Result(property = "orderTime", column = "orderTime"),
          @Result(property = "orderStatus", column = "orderStatus"),
          @Result(property = "peopleCount", column = "peopleCount"),
          @Result(property = "payType", column = "payType"),
          @Result(property = "orderDesc", column = "orderDesc"),
          @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "it.cast.jiewen.web.dao.ProductDao.findByid")),
  })
  /************************查询订单详情**************/
  public List<Orders> findAll() throws Exception;
  @Select("select * from orders where id=#{id}")
  @Results({
          @Result(id = true, property = "id", column = "id"),
          @Result(property = "orderNum", column = "orderNum"),
          @Result(property = "orderTime", column = "orderTime"),
          @Result(property = "orderStatus", column = "orderStatus"),
          @Result(property = "peopleCount", column = "peopleCount"),
          @Result(property = "payType", column = "payType"),
          @Result(property = "orderDesc", column = "orderDesc"),
          @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "it.cast.jiewen.web.dao.ProductDao.findByid")),
          @Result(property = "member",column = "memberid",javaType = Member.class,one = @One(select="it.cast.jiewen.web.dao.MemberDao.findByid")),
          @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select="it.cast.jiewen.web.dao.TravellerDao.findByid")),
  })
  public Orders findByid(String id);
}
