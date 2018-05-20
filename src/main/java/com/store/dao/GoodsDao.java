package com.store.dao;

import com.store.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    int save(Goods admin);

    int delete(int id);

    int update(Goods admin);

    List<Goods> queryAll();

    List<Map<String, Object>> queryAll(Integer curpage, Integer pageSize);

    Integer queryRecords();

    Goods queryById(int id);
}
