package com.store.dao;

import com.store.entity.Admin;

import java.util.List;

public interface AdminDao {
    int save(Admin admin);

    int delete(int id);

    int update(Admin admin);

    List<Admin> queryAll();

    Admin queryById(int id);

    Admin queryByColum(String colum,Object value);


}
