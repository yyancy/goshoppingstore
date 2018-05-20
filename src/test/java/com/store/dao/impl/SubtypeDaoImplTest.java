package com.store.dao.impl;

import com.store.dao.SubtypeDao;
import com.store.dao.SupertypeDao;
import com.store.entity.Subtype;
import com.store.entity.Supertype;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class SubtypeDaoImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SubtypeDao subtypeDao = new SubtypeDaoImpl();
    @Test
    public void save() {
        Subtype subtype = new Subtype(1,"1");
        int save = subtypeDao.save(subtype);
        logger.info("{}",save);
    }

    @Test
    public void delete() {
        int delete = subtypeDao.delete(1);
        logger.info("{}",delete);
    }

    @Test
    public void update() {
        Subtype subtype = subtypeDao.queryById(1);
        subtype.setSuperType(222);
        int update = subtypeDao.update(subtype);
        logger.info("{}",update);
    }

    @Test
    public void queryAll() {
        List<Subtype> list = subtypeDao.queryAll();
        for (Subtype subtype : list) {
            logger.info("{}",subtype);

        }
    }

    @Test
    public void queryById() {
        Subtype subtype = subtypeDao.queryById(1);
        logger.info("{}",subtype);
    }
}