package com.store.dao;

import com.store.entity.Message;

import java.util.List;

public interface MessageDao {

    int save(Message admin);

    int delete(int id);

    int update(Message admin);

    List<Message> queryAll();

    Message queryById(int id);
}
