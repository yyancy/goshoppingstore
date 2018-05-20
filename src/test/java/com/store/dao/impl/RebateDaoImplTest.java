package com.store.dao.impl;

import com.store.dao.RebateDao;
import com.store.entity.Rebate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class RebateDaoImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RebateDao rebateDao = new RebateDaoImpl();
    @Test
    public void save() {
        Rebate rebate = new Rebate(1,new BigDecimal(1));
        int save = rebateDao.save(rebate);
        logger.info("{}",save);
    }

    @Test
    public void delete() {
        int status = rebateDao.delete(1);
        logger.info("{}",status);
    }

    @Test
    public void update() {
        Rebate rebate = rebateDao.queryById(1);
        rebate.setMinScore(2000);
        int update = rebateDao.update(rebate);
        logger.info("{}",update);
    }

    @Test
    public void queryAll() {
        List<Rebate> rebateList = rebateDao.queryAll();
        for (Rebate rebate : rebateList) {
            logger.info("{}",rebate);
        }
    }

    @Test
    public void queryById() {
        Rebate rebate = rebateDao.queryById(1);
        logger.info("{}",rebate);
    }
}