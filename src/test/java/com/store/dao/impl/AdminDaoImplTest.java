package com.store.dao.impl;

import com.store.dao.AdminDao;
import com.store.entity.Admin;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class AdminDaoImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private AdminDao adminDao = new AdminDaoImpl();
    @Test
    public void save() {
        Admin admin = new Admin("董洋","123456");
        int save = adminDao.save(admin);
        logger.info("修改的状态:{}",save);
    }

    @Test
    public void delete() {
        int delete = adminDao.delete(2);
        logger.info("删除的状态{}",delete);
    }

    @Test
    public void update() {
        Admin admin = adminDao.queryById(1);
        admin.setName("what??");
        int update = adminDao.update(admin);
        logger.info("修改的状态:{}",update);

    }

    @Test
    public void queryAll() {
        List<Admin> admins = adminDao.queryAll();
        for (Admin admin : admins) {
            logger.info("ss {}",admin);
        }
    }

    @Test
    public void queryById() {
        Admin admin = adminDao.queryById(3);
        logger.info("{}",admin);
    }
}