package it.cast.jiewen.web.service;

import it.cast.jiewen.web.dao.OrdersDao;
import it.cast.jiewen.web.domain.Orders;
import it.cast.jiewen.web.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface OrdersService {
    List<it.cast.jiewen.web.domain.Orders> findAll(int page,int size) throws Exception;

   public Orders findByid(String id);
}