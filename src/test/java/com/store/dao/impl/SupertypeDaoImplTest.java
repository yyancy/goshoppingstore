package com.store.dao.impl;

import com.store.dao.SupertypeDao;
import com.store.dto.Page;
import com.store.entity.Supertype;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class SupertypeDaoImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SupertypeDao supertypeDao = new SupertypeDaoImpl();

    @Test
    public void save() {
        Supertype supertype = new Supertype("1");
        int save = supertypeDao.save(supertype);
        logger.info("{}",save);
    }

    @Test
    public void delete() {
        int delete = supertypeDao.delete(5);
        logger.info("{}",delete);
    }

    @Test
    public void update() {
        Supertype supertype = supertypeDao.queryById(2);
        supertype.setTypeName("222");
        int update = supertypeDao.update(supertype);
        logger.info("{}",update);
    }

    @Test
    public void queryAll() {
        List<Supertype> supertypes = supertypeDao.queryAll();
        for (Supertype supertype : supertypes) {
            logger.info("{}",supertype);
        }
    }

    @Test
    public void queryById() {
        Supertype supertype = supertypeDao.queryById(2);
        logger.info("{}",supertype);
    }
    @Test
    public void queryAlls(){
        Page page = new Page(2,4);
        List<Supertype> list = supertypeDao.queryAll(page.getCurpage(), page.getPageSize());
        for (Supertype supertype : list) {
            logger.info("{}",supertype);
        }
    }

    @Test
    public void totalRecords(){
        Integer integer = supertypeDao.queryRecords();
        logger.info("{}",integer);
    }
}