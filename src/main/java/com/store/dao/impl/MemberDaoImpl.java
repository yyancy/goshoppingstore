package com.store.dao.impl;

import com.store.dao.MemberDao;
import com.store.entity.Member;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

    /**
     * execution save action
     *
     * @param member 一个要存储对象的
     * @return
     */
    @Override
    public int save(Member member) {
        String sql = "insert into tb_member(" + member.getFields() + ") values(?,?,?,?,?,?,?,?,?,?)";
        int save = 0;
        try {

            save = queryRunner.update(sql, member.getName()
                    , member.getRealName(),
                    member.getPwd(),
                    member.getCity(),
                    member.getAddress(),
                    member.getIdCard(),
                    member.getJobType(),
                    member.getQq(),
                    member.getTelephone(),
                    member.getEmail());
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return save;
    }

    /**
     * execution delete action
     *
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        String sql = "delete from tb_member where id=?";
        int delete = -1;
        try {
            delete = queryRunner.update(sql, id);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return delete;
    }

    @Override
    public int update(Member member) {

        String sql = "update tb_member set name=?,realName=?,pwd=?,city=?,address=?," +
                "idCard=?,jobType=?,score=?,qq=?,telephone=?,email=?,free=? where id=?";
        int update = -1;
        try {
            update = queryRunner.update(sql, member.getName()
                    , member.getRealName(),
                    member.getPwd(),
                    member.getCity(),
                    member.getAddress(),
                    member.getIdCard(),
                    member.getJobType(),
                    member.getScore(),
                    member.getQq(),
                    member.getTelephone(),
                    member.getEmail(),
                    member.getFree(),
                    member.getId());
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return update;
    }

    /**
     * execution query all action,not have paging
     * @return list contains all member;
     */
    @Override
    public List<Member> queryAll() {
        String sql = "select * from tb_member";
        List<Member> query = null;
        try {
           query = queryRunner.query(sql, new BeanListHandler<>(Member.class));
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return query;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 一个member对象
     */
    @Override
    public Member queryById(int id) {
        String sql = "select * from tb_member where id = ?";
        Member member = null;
        try {
            member =  queryRunner.query(sql,new BeanHandler<>(Member.class),id);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return member;
    }

    @Override
    public Member queryByColum(String  colum,Object value) {
        String sql = "select * from tb_member where "+colum+"=?";
        Member member = null;
        try {
            member =  queryRunner.query(sql,new BeanHandler<>(Member.class),value);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        return member;
    }
}