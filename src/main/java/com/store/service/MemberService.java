package com.store.service;


import com.store.entity.Member;

import java.util.List;

public interface MemberService {

    int save(Member member);

    int delete(int id);

    int update(Member member);

    List<Member> queryAll();

    Member queryById(int id);

    Integer login(String name,String pwd);

}
