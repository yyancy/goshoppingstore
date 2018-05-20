package com.store.service;

import com.store.dto.Page;
import com.store.entity.Subtype;

import java.util.List;
import java.util.Map;

public interface SubtypeService {
    int save(Subtype subtype);

    int delete(int id);

    int update(Subtype subtype);

    List<Subtype> queryAll();

    List<Map<String, Object>> queryAll(Page page);

    Subtype queryById(int id);
}
