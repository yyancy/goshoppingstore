package com.store.service;

import com.store.dto.Page;
import com.store.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    int save(Goods goods);

    int delete(int id);

    int update(Goods goods);

    List<Goods> queryAll();

    List<Map<String, Object>> queryAll(Page page);

    Goods queryById(int id);
}
