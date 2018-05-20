package com.store.service.impl;

import com.store.dao.GoodsDao;
import com.store.dao.impl.GoodsDaoImpl;
import com.store.dto.Page;
import com.store.entity.Goods;
import com.store.service.GoodsService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public int save(Goods goods) {

        return goodsDao.save(goods);
    }

    @Override
    public int delete(int id) {
        return goodsDao.delete(id);
    }

    @Override
    public int update(Goods goods) {
        return goodsDao.update(goods);
    }

    @Override
    public List<Goods> queryAll() {

        return goodsDao.queryAll();
    }

    @Override
    public List<Map<String, Object>> queryAll(Page page) {
        Integer allRecord = goodsDao.queryRecords();
        List<Map<String, Object>> list = null;

        if (Objects.nonNull(allRecord)){
            list = goodsDao.queryAll(page.getCurpage(), page.getPageSize());
            for (Map<String, Object> stringObjectMap : list) {
                System.out.println(stringObjectMap);
            }
            page.setAllRecord(allRecord);
        }
        return list;
    }

    @Override
    public Goods queryById(int id) {
        return goodsDao.queryById(id);
    }
}
