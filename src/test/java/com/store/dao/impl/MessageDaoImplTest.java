package com.store.dao.impl;

import com.store.dao.MessageDao;
import com.store.entity.Message;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;
import java.util.List;


public class MessageDaoImplTest {

    private Logger logger =LoggerFactory.getLogger(this.getClass());
    private MessageDao messageDao = new MessageDaoImpl();
    @Test
    public void save() {
        Message message = new Message("1","1",new Date());
        int save = messageDao.save(message);
        logger.info("show {}",save);
    }

    @Test
    public void delete() {
        int delete = messageDao.delete(1);
        logger.info("show {}",delete);
    }

    @Test
    public void update() {
        Message message = messageDao.queryById(1);
        message.setTitle("dy");
        int update = messageDao.update(message);
        logger.info("show {}",update);
    }

    @Test
    public void queryAll() {
        List<Message> messages = messageDao.queryAll();
        for (Message message : messages) {
            logger.info("{}",message);
        }
    }

    @Test
    public void queryById() {
        Message message = messageDao.queryById(1);
        logger.info("{}",message);

    }
}