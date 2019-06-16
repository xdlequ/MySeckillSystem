package com.sun.seckill.service.impl;

import com.sun.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public Goods select(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }
}
