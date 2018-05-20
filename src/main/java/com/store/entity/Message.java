package com.store.entity;

import java.util.Date;

public class Message {
    private Integer id;
    private String title;
    private String  content;
    private Date inTime;

    public Message(){

    }

    public Message(String title, String content, Date inTime) {
        this.title = title;
        this.content = content;
        this.inTime = inTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", inTime=" + inTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
}

