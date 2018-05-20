package com.store.service.impl;

import com.store.dao.SubtypeDao;
import com.store.dao.impl.SubtypeDaoImpl;
import com.store.dto.Page;
import com.store.entity.Subtype;
import com.store.service.SubtypeService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubtypeServiceImpl implements SubtypeService {

    private SubtypeDao subtypeDao = new SubtypeDaoImpl();

    @Override
    public int save(Subtype subtype) {
        return subtypeDao.save(subtype);
    }

    @Override
    public int delete(int id) {
        return subtypeDao.delete(id);
    }

    @Override
    public int update(Subtype subtype) {
        return subtypeDao.update(subtype);
    }

    @Override
    public List<Subtype> queryAll() {

        return subtypeDao.queryAll();
    }

    @Override
    public List<Map<String, Object>> queryAll(Page page) {
        Integer allRecord = subtypeDao.queryRecords();
        List<Map<String, Object>> list = null;
        if (Objects.nonNull(allRecord)){
            list = subtypeDao.queryAll(page.getCurpage(), page.getPageSize());
            page.setAllRecord(allRecord);
        }
        return list;
    }

    @Override
    public Subtype queryById(int id) {
        return subtypeDao.queryById(id);
    }
}
