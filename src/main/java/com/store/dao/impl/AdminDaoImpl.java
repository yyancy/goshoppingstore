package com.store.dao.impl;

import com.store.dao.AdminDao;
import com.store.entity.Admin;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    public int save(Admin admin) {
        String sql = "insert into tb_admin(name,pwd) values(?,?)";
        int saveStatus = 0;
        try {
            saveStatus = queryRunner.update(sql, admin.getName(), admin.getPwd());
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

        return saveStatus;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_admin where id=?";
        int update = 0;
        try {
            update = queryRunner.update(sql, id);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

        return update;
    }

    @Override
    public int update(Admin admin) {
        String sql = "update tb_admin set name=?,pwd=? where id=?";
        int update = 0;
        try {
            update = queryRunner.update(sql, admin.getName(), admin.getPwd(), admin.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return update;
    }

    @Override
    public List<Admin> queryAll() {
        String sql = "select * from tb_admin";
        List<Admin> query = null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<>(Admin.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return query;
    }

    @Override
    public Admin queryById(int id) {
        String sql = "select * from tb_admin where id=?";
        Admin admin = null;
        try {
            admin = queryRunner.query(sql, new BeanHandler<>(Admin.class), id);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return admin;
    }

    @Override
    public Admin queryByColum(String colum, Object value) {
        String sql = "select * from tb_admin where "+colum+"=?";
        Admin admin = null;
        try {
            admin = queryRunner.query(sql,new BeanHandler<>(Admin.class),value);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return admin;

    }
}
