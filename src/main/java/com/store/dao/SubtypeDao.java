package com.store.dao;

import com.store.dto.Page;
import com.store.entity.Subtype;

import java.util.List;
import java.util.Map;

public interface SubtypeDao {
    int save(Subtype subtype);

    int delete(int id);

    int update(Subtype subtype);

    List<Subtype> queryAll();

    List<Map<String, Object>> queryAll(Integer curpage, Integer pageSize);

    Subtype queryById(int id);

    Integer queryRecords();
}
