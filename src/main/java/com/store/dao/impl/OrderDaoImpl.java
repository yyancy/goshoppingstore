package com.store.dao.impl;

import com.store.dao.OrderDao;
import com.store.entity.Admin;
import com.store.entity.Order;
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

public class OrderDaoImpl implements OrderDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public int save(Order order) {
        String sql = "insert into tb_order(memberId,customName,address,qq,telephone,payType,orderTime,state,bz) values(?,?,?,?,?,?,?,?,?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,order.getMemberId(),
                    order.getCustomName(),
                    order.getAddress(),
                    order.getQq(),
                    order.getTelephone(),
                    order.getPayType(),
                    order.getOrderTime(),
                    order.getState(),
                    order.getBz());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }

        return status;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_order where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int update(Order order) {
        String sql ="update tb_order set memberId=?,customName=?,address=?,qq=?,telephone=?,payType=?,orderTime=?,state=?,bz=? where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,order.getMemberId(),
                    order.getCustomName(),
                    order.getAddress(),
                    order.getQq(),
                    order.getTelephone(),
                    order.getPayType(),
                    order.getOrderTime(),
                    order.getState(),
                    order.getBz(),
                    order.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public List<Order> queryAll() {
        String sql = "select * from tb_order";
        List<Order> orders = null;
        try {
            orders = queryRunner.query(sql,new BeanListHandler<>(Order.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return orders;
    }

    @Override
    public List<Map<String, Object>> queryAll(Integer curpage, Integer pageSize) {
        String sql = "select o.id oid,d.number,o.customName,g.name,o.payType,d.price,o.orderTime,o.state from tb_order_detail d "+
        "inner join tb_order o on o.id=d.orderId "+
        "inner join tb_goods g on g.id=d.goodsId  limit ?,?";
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
        String sql = "select count(*) from tb_order";
        Long records = 0L;
        try {
            records = queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return records.intValue();
    }

    @Override
    public Order queryById(int id) {
        String sql ="select * from tb_order where id=?";
        Order order = null;
        try {
            order = queryRunner.query(sql,new BeanHandler<>(Order.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return order;
    }

    @Override
    public int upstate(int id, int state) {
        String sql = "update tb_order set state = ? where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,state,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;

    }
}
