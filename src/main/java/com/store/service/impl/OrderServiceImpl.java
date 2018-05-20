package com.store.service.impl;

import com.store.dao.OrderDao;
import com.store.dao.impl.OrderDaoImpl;
import com.store.dto.Page;
import com.store.entity.Order;
import com.store.service.OrderService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public int save(Order order) {
        return orderDao.save(order);
    }

    @Override
    public int delete(int id) {
        return orderDao.delete(id);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> queryAll() {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryAll(Page page) {
        Integer allRecord = orderDao.queryRecords();
        List<Map<String, Object>> list = null;
        if (Objects.nonNull(allRecord)){
            list = orderDao.queryAll(page.getCurpage(), page.getPageSize());
            page.setAllRecord(allRecord);
        }
        return list;
    }

    @Override
    public Order queryById(int id) {
        return orderDao.queryById(id);
    }

    @Override
    public int upstate(int id,int state) {
        return orderDao.upstate(id,state);
    }
}
