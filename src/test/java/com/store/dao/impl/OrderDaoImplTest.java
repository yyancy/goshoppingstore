package com.store.dao.impl;

import com.store.dao.OrderDao;
import com.store.entity.Order;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    private Logger logger =LoggerFactory.getLogger(this.getClass());
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void save() {
        Order order = new Order(1,"1","1","1","1","1",new Date(),1,"1");
        int save = orderDao.save(order);
        logger.info("{}",save);
    }

    @Test
    public void delete() {
        int delete = orderDao.delete(2);
        logger.info("{}",delete);
    }

    @Test
    public void update() {
        Order order = orderDao.queryById(2);
        order.setCustomName("dy");
        int update = orderDao.update(order);
        logger.info("{}",update);
    }

    @Test
    public void queryAll() {
        List<Order> orders = orderDao.queryAll();
        for (Order order : orders) {
            logger.info("{}",order);
        }
    }

    @Test
    public void queryAll2() {
        List<Map<String, Object>> maps = orderDao.queryAll(1, 4);
        for (Map<String, Object> order : maps) {

            logger.info("{}:",order);
        }
    }

    @Test
    public void queryById() {
        Order order = orderDao.queryById(2);
        logger.info("{}",order);
    }
}