package com.store.service.impl;

import com.store.dao.MemberDao;
import com.store.dao.impl.MemberDaoImpl;
import com.store.entity.Member;
import com.store.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public int save(Member member) {
        return memberDao.save(member);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public List<Member> queryAll() {
        return null;
    }

    @Override
    public Member queryById(int id) {
        return null;
    }

    @Override
    public Integer login(String name, String pwd) {
        Member member = memberDao.queryByColum("name", name);
        if (member != null && pwd.equals(member.getPwd())) {
            return member.getId();
        }
        return null;
    }
}
