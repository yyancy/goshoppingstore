package com.store.dao.impl;

import com.store.dao.GoodsDao;
import com.store.entity.Goods;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GoodsDaoImplTest {

    private GoodsDao goodsDao = new GoodsDaoImpl();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void save() {
        Goods goods = new Goods(1,"1","1",1,1,"1",new Date(),1,0);
        int save = goodsDao.save(goods);
        logger.info("show influence{}",save);

    }

    @Test
    public void delete() {
        int delete = goodsDao.delete(1);
        logger.info("show influence{}",delete);
    }

    @Test
    public void update() {
        Goods goods = goodsDao.queryById(1);
        goods.setName("dys");
        int update = goodsDao.update(goods);
        logger.info("zhuangtai {}",update);
    }

    @Test
    public void queryAll() {
        List<Goods> goods = goodsDao.queryAll();
        for (Goods good : goods) {
            logger.info("{}",good);
        }
    }   @Test
    public void queryAll2() {
        List<Map<String,Object>> goods = goodsDao.queryAll(1,4);
        for (Map good : goods) {
            logger.info("{}",good);
        }
    }

    @Test
    public void queryById() {
        Goods goods = goodsDao.queryById(1);
        logger.info("{}",goods);
    }
}