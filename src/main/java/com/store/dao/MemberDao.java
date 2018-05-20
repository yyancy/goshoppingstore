package com.store.dao;

import com.store.entity.Member;

import java.util.List;

public interface MemberDao {

    int save(Member member);

    int delete(int id);

    int update(Member member);

    List<Member> queryAll();

    Member queryById(int id);

    Member queryByColum(String colum,Object value);

}
