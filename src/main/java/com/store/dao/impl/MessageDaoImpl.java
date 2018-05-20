package com.store.dao.impl;

import com.store.dao.MessageDao;
import com.store.entity.Message;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());


    @Override
    public int save(Message message) {
        String sql = "insert into tb_message(title,content,inTime) values(?,?,?)";
        int status = 0;
        try {
            status = queryRunner.update(sql,message.getTitle(),
                    message.getContent(),
                    message.getInTime());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from tb_message where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public int update(Message message) {
        String sql = "update tb_message set title=?,content=?,inTime=? where id=?";
        int status = 0;
        try {
            status = queryRunner.update(sql,message.getTitle(),
                    message.getContent(),
                    message.getInTime(),
                    message.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return status;
    }

    @Override
    public List<Message> queryAll() {
        String sql = "select * from tb_message";
        List<Message> messages = null;
        try {
            messages =  queryRunner.query(sql,new BeanListHandler<>(Message.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return messages;
    }

    @Override
    public Message queryById(int id) {
        String sql = "select * from tb_message where id=?";
        Message message = null;
        try {
            message = queryRunner.query(sql,new BeanHandler<>(Message.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return message;
    }
}
