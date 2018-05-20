package com.store.dao.impl;

import com.store.dao.SupertypeDao;
import com.store.entity.Supertype;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class SupertypeDaoImpl implements SupertypeDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    public int save(Supertype supertype) {

        String sql = "insert into tb_supertype(typeName) values(?)";
        int status = 0;
        try {
            status = queryRunner.update(sql, supertype.getTypeName());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_supertype where id=? and" +
                " not exists(select supertype from tb_subtype" +
                " where supertype=?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,id,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int update(Supertype supertype) {
        String sql = "update tb_supertype set typeName=? where id=?";
        int status =0;
        try {
            status = queryRunner.update(sql,supertype.getTypeName(),
                    supertype.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public List<Supertype> queryAll() {
        String sql= "select * from tb_supertype";
        List<Supertype> lists = null;
        try {
            lists = queryRunner.query(sql,new BeanListHandler<>(Supertype.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return lists;
    }

    @Override
    public Supertype queryById(int id) {
        String sql = "select * from tb_supertype where id=?";
        Supertype supertype = null;
        try {
            supertype = queryRunner.query(sql,new BeanHandler<>(Supertype.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return supertype;
    }

    @Override
    public Integer queryRecords() {
        String sql = "select count(*) from tb_supertype";
        Long records = 0L;
        try {
            records = queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }

        return records.intValue();
    }

    @Override
    public List<Supertype> queryAll(Integer curpage, Integer pageSize) {
        String sql = "select * from tb_supertype limit ?,?";
        List<Supertype> lists = null;
        try {
            lists = queryRunner.query(sql,new BeanListHandler<>(Supertype.class),
                    (curpage-1)*pageSize,pageSize);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return lists;
    }


}
