package com.store.dao;

import com.store.entity.Rebate;

import java.util.List;

public interface RebateDao {
    int save(Rebate admin);

    int delete(int id);

    int update(Rebate admin);

    List<Rebate> queryAll();

    Rebate queryById(int id);
}
