package com.store.dao.impl;

import com.store.dao.Order_detailDao;
import com.store.entity.Order_Detail;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class Order_detailImplTest {

    private Order_detailDao order_detailDao = new Order_detailImpl();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void save() {
        Order_Detail orderDetail = new Order_Detail(1,1,new BigDecimal(1),1);
        int save = order_detailDao.save(orderDetail);
        logger.info("{}",save);

    }

    @Test
    public void delete() {
        int delete = order_detailDao.delete(1);
        logger.info("{}",delete);
    }

    @Test
    public void update() {
        Order_Detail orderDetail = order_detailDao.queryById(2);
        orderDetail.setOrderId(222);
        int update = order_detailDao.update(orderDetail);
        logger.info("{}",update);
    }

    @Test
    public void queryAll() {
        List<Order_Detail> orderDetailList = order_detailDao.queryAll();
        for (Order_Detail orderDetail : orderDetailList) {
            logger.info("{}",orderDetail);
        }
    }

    @Test
    public void queryById() {
        Order_Detail orderDetail = order_detailDao.queryById(2);
        logger.info("{}",orderDetail);

    }
}