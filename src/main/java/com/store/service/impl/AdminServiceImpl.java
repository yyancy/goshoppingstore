package com.store.service.impl;

import com.store.dao.AdminDao;
import com.store.dao.impl.AdminDaoImpl;
import com.store.entity.Admin;

import java.util.List;
import java.util.Objects;

public class AdminServiceImpl implements com.store.service.AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int save(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public List<Admin> queryAll() {
        return null;
    }

    @Override
    public Admin queryById(int id) {
        return null;
    }

    @Override
    public Integer login(String name, String pwd) {
        Admin admin = adminDao.queryByColum("name", name);
        if (Objects.nonNull(admin) && pwd.equals(admin.getPwd())) {
            return admin.getId();
        }
        return null;
    }
}
