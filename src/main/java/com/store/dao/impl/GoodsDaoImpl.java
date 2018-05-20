package com.store.dao.impl;

import com.store.dao.GoodsDao;
import com.store.entity.Goods;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.DbUtils;
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

public class GoodsDaoImpl implements GoodsDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public int save(Goods goods) {
        String sql = "insert into tb_goods(tid" +
                ",name,introduce,price,reducePrice,photo,inTime,saleNumber,hit) values(?,?,?,?,?,?,?,?,?)";
        int save = 0;
        try {
            save = queryRunner.update(sql,goods.getTid(),
                    goods.getName(),
                    goods.getIntroduce(),
                    goods.getPrice(),
                    goods.getReducePrice(),
                    goods.getPhoto(),
                    goods.getIntime(),
                    goods.getSaleNumber(),
                    goods.getHit());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return save;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_goods where id=?";
        int delete = 0;
        try {
            delete = queryRunner.update(sql,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return  delete;
    }

    @Override
    public int update(Goods goods) {
        String sql = "update tb_goods set tid=?,name=?,introduce=?,price=?,reducePrice=?,photo=?,inTime=?,saleNumber=?,hit=? where id=?";
        int update = 0;
        try {
            update = queryRunner.update(sql,goods.getTid(),
                    goods.getName(),
                    goods.getIntroduce(),
                    goods.getPrice(),
                    goods.getReducePrice(),
                    goods.getPhoto(),
                    goods.getIntime(),
                    goods.getSaleNumber(),
                    goods.getHit(),
                    goods.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return update;
    }

    @Override
    public List<Goods> queryAll() {
        String sql = "select * from tb_goods";
        List<Goods> query = null;
        try {
           query = queryRunner.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return query;
    }

    @Override
    public List<Map<String, Object>> queryAll(Integer curpage, Integer pageSize) {
        String sql = "select g.*,s.id sid,s.typeName from tb_goods g" +
                " inner join tb_subtype s on g.tid=s.id limit ?,?";
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
    public Integer queryRecords() {
        String sql = "select count(*) from tb_goods";
        Long records = 0L;
        try {
            records = queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return records.intValue();
    }

    @Override
    public Goods queryById(int id) {
        String sql = "select * from tb_goods where id=?";
        Goods goods = null;
        try {
            goods =  queryRunner.query(sql,new BeanHandler<>(Goods.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return  goods;
    }
}
