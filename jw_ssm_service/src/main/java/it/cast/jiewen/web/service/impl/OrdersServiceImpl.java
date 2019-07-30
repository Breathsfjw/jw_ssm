package it.cast.jiewen.web.service.impl;

import com.github.pagehelper.PageHelper;
import it.cast.jiewen.web.dao.OrdersDao;
import it.cast.jiewen.web.domain.Orders;
import it.cast.jiewen.web.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrdersServiceImpl implements OrdersService {
    @Autowired
   private  OrdersDao ordersDao;
    @Override
    public List<it.cast.jiewen.web.domain.Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findByid(String id) {
        return ordersDao.findByid(id);
    }
}
