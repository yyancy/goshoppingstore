package com.store.service;

import com.store.dto.Page;
import com.store.entity.Supertype;

import java.util.List;

public interface SupertypeService {

    int save(Supertype supertype);

    int delete(int id);

    int update(Supertype supertype);

    List<Supertype> queryAll();

    List<Supertype> queryTypes();

    List<Supertype> queryAll(Page page);

    Supertype queryById(int id);

}
