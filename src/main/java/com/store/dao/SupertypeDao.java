package com.store.dao;

import com.store.entity.Supertype;

import java.util.List;

public interface SupertypeDao {
    int save(Supertype supertype);

    int delete(int id);

    int update(Supertype supertype);

    List<Supertype> queryAll();

    Supertype queryById(int id);

    Integer queryRecords();

    List<Supertype> queryAll(Integer curpage,Integer pageSize);
}
