package com.store.dao;

import com.store.entity.Order_Detail;

import java.util.List;

public interface Order_detailDao {
    int save(Order_Detail admin);

    int delete(int id);

    int update(Order_Detail admin);

    List<Order_Detail> queryAll();

    Order_Detail queryById(int id);
}
