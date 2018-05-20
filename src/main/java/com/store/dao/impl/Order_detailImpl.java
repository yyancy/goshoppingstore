package com.store.dao.impl;

import com.store.dao.Order_detailDao;
import com.store.entity.Order_Detail;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class Order_detailImpl implements Order_detailDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public int save(Order_Detail order_detail) {
        String sql = "insert into tb_order_detail(orderId,goodsId,price,number) values(?,?,?,?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,order_detail.getOrderId(),
                    order_detail.getGoodsId(),
                    order_detail.getPrice(),
                    order_detail.getNumber());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int delete(int id) {

        String sql = "delete from tb_order_detail where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int update(Order_Detail order_detail) {
        String sql = "update tb_order_detail set orderId=?,goodsId=?,price=?,number=? where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,order_detail.getOrderId(),
                    order_detail.getGoodsId(),
                    order_detail.getPrice(),
                    order_detail.getNumber(),
                    order_detail.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public List<Order_Detail> queryAll() {
        String sql = "select * from tb_order_detail";
        List<Order_Detail> orderDetailList = null;
        try {
            orderDetailList = queryRunner.query(sql,new BeanListHandler<>(Order_Detail.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return orderDetailList;
    }

    @Override
    public Order_Detail queryById(int id) {
        String sql = "select * from tb_order_detail where id=?";
        Order_Detail orderDetail = null;
        try {
            orderDetail = queryRunner.query(sql,new BeanHandler<>(Order_Detail.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return orderDetail;
    }
}
