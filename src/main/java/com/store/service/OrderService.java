package com.store.service;

import com.store.dto.Page;
import com.store.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    int save(Order order);

    int delete(int id);

    int update(Order order);

    List<Order> queryAll();

    List<Map<String, Object>> queryAll(Page page);

    Order queryById(int id);

    int upstate(int id,int state);
}
