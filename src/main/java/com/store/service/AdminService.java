package com.store.service;

import com.store.entity.Admin;

import java.util.List;

public interface AdminService {

    int save(Admin admin);

    int delete(int id);

    int update(Admin admin);

    List<Admin> queryAll();

    Admin queryById(int id);

    Integer login(String name,String pwd);
}
