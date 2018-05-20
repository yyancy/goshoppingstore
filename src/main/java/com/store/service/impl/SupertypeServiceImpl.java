package com.store.service.impl;

import com.store.dao.SubtypeDao;
import com.store.dao.SupertypeDao;
import com.store.dao.impl.SubtypeDaoImpl;
import com.store.dao.impl.SupertypeDaoImpl;
import com.store.dto.Page;
import com.store.entity.Supertype;
import com.store.service.SupertypeService;

import java.util.List;
import java.util.Objects;

public class SupertypeServiceImpl implements SupertypeService {

    private SupertypeDao supertypeDao = new SupertypeDaoImpl();
    private SubtypeDao subtypeDao = new SubtypeDaoImpl();
    @Override
    public int save(Supertype supertype) {
        return supertypeDao.save(supertype);
    }

    @Override
    public int delete(int id) {
        //subtypeDao.q
        return supertypeDao.delete(id);
    }

    @Override
    public int update(Supertype supertype) {
        return supertypeDao.update(supertype);
    }

    @Override
    public List<Supertype> queryAll() {
        List<Supertype> list = supertypeDao.queryAll();

        return null;
    }

    @Override
    public List<Supertype> queryTypes() {


        return supertypeDao.queryAll();
    }

    @Override
    public List<Supertype> queryAll(Page page) {
        Integer allRecord = supertypeDao.queryRecords();
        List<Supertype> list = null;
        if (Objects.nonNull(allRecord)){
            list = supertypeDao.queryAll(page.getCurpage(), page.getPageSize());
            page.setAllRecord(allRecord);
        }
        return list;
    }

    @Override
    public Supertype queryById(int id) {

        return supertypeDao.queryById(id);
    }

}
