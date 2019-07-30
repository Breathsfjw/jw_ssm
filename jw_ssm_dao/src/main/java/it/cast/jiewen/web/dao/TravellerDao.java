package it.cast.jiewen.web.dao;

import it.cast.jiewen.web.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("select *from traveller where id in (select travellerID from order_traveller where orderid=#{id})")
    public List<Traveller> findByid(String id) throws  Exception;
}
