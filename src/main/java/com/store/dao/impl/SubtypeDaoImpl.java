package com.store.dao.impl;

import com.store.dao.SubtypeDao;
import com.store.dto.Page;
import com.store.entity.Subtype;
import com.store.entity.Supertype;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SubtypeDaoImpl implements SubtypeDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public int save(Subtype subtype) {
        String sql = "insert into tb_subtype(superType,typeName) values(?,?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,subtype.getSuperType(),
                    subtype.getTypeName());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_subtype where id=? " +
                "and not exists(select tid from tb_goods where tid=?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,id,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int update(Subtype subtype) {
        String sql = "update tb_subtype set superType=?,typeName=? where id=?";
        int status =0;
        try {
            status = queryRunner.update(sql,subtype.getSuperType(),
                    subtype.getTypeName(),
                    subtype.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public List<Subtype> queryAll() {
        String sql= "select * from tb_subtype";
        List<Subtype> lists = null;
        try {
            lists = queryRunner.query(sql,new BeanListHandler<>(Subtype.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return lists;
    }

    @Override
    public List<Map<String, Object>> queryAll(Integer curpage, Integer pageSize) {
        String sql = "select s.id,s.superType,s.typeName,p.typeName as superTypeName  from tb_subtype s" +
                " inner join tb_supertype p on s.superType=p.id limit ?,?";
        List<Map<String, Object>> lists = null;
        try {
            lists = queryRunner.query(sql,new MapListHandler(),
                    (curpage-1)*pageSize,pageSize);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return lists;
    }

    @Override
    public Subtype queryById(int id) {
        String sql = "select * from tb_subtype where id=?";
        Subtype subtype = null;
        try {
            subtype = queryRunner.query(sql,new BeanHandler<>(Subtype.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return subtype;
    }

    @Override
    public Integer queryRecords() {
       String sql = "select count(*) from tb_subtype";
       Long records = 0L;
        try {
            records = queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return records.intValue();
    }
}
