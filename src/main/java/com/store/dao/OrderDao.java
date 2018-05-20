package com.store.dao;

import com.store.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    int save(Order order);

    int delete(int id);

    int update(Order order);

    List<Order> queryAll();

    List<Map<String, Object>> queryAll(Integer curpage, Integer pageSize);

    Integer queryRecords();

    Order queryById(int id);

    int upstate(int id,int state);
}
