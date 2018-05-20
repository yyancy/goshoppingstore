package com.store.dao.impl;

import com.store.dao.RebateDao;
import com.store.entity.Rebate;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class RebateDaoImpl implements RebateDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    public int save(Rebate rebate) {
        String sql = "insert into tb_rebate(minScore,rebate) values(?,?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,rebate.getMinScore(),
                    rebate.getRebate());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_rebate where id =?";

        int status = 0;
        try {
            status = queryRunner.update(sql,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int update(Rebate rebate) {
        String sql = "update tb_rebate set minScore=?,rebate=? where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,rebate.getMinScore(),
                    rebate.getRebate(),
                    rebate.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public List<Rebate> queryAll() {
        String sql = "select * from tb_rebate";
        List<Rebate> rebateList = null;
        try {
            rebateList = queryRunner.query(sql,new BeanListHandler<>(Rebate.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return rebateList;
    }

    @Override
    public Rebate queryById(int id) {
        String sql = "select * from tb_rebate where id=?";
        Rebate rebate = null;
        try {
            rebate = queryRunner.query(sql,new BeanHandler<>(Rebate.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return rebate;
    }
}
