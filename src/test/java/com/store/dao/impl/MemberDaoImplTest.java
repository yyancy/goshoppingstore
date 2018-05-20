package com.store.dao.impl;

import com.store.dao.MemberDao;
import com.store.entity.Member;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MemberDaoImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private MemberDao memberDao = new MemberDaoImpl();
    @Test
    public void save() {
        Member member = new Member("1","1","1","1",
                "1","1","1","1","1","1");
        int save = memberDao.save(member);
        logger.info("show influence {}",save);
    }

    @Test
    public void delete() {
        int delete = memberDao.delete(2);
        logger.info("show influence {}",delete);
    }

    @Test
    public void update() {
        Member member = memberDao.queryById(1);
       member.setRealName("dyssss");
        int update = memberDao.update(member);
        logger.info("show influence line {}",update);
    }

    @Test
    public void queryAll() {
        List<Member> members = memberDao.queryAll();
        for (Member member : members) {
            logger.info("member info {}",member);
        }
    }

    @Test
    public void queryById() {
        Member member = memberDao.queryById(4);
        logger.info("member info: {}",member);
    }
}