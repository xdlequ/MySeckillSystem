package com.sun.seckill.controller;

import com.sun.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    /**
     * 增加商品，方法使用POST类型，通过访问/goods 进行，在请求的body中添加json格式数据。<p/>
     * String goodName; 商品名称<p/>
     * BigDecimal price; 商品价格
     *
     * @param goods
     * @return
     */
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public String addGoods(@RequestBody Goods goods) {
        goods.setCreateTime(new Timestamp(System.currentTimeMillis()));
        goods.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        service.insert(goods);
        return "add goods success";
    }

    /**
     * 选取商品，方法使用GET类型，通过访问 /goods/{id} 进行，根据主键进行查询，查询结果中返回为json格式数据。<p/>
     * Integer id;主键id<BR/>
     * String goodName; 商品名称<BR/>
     * BigDecimal price; 商品价格<BR/>
     * Date createTime; 创建时间<BR/>
     * Date updateTime; 更新时间
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public Goods selectGoods(@PathVariable Integer id) {
        Goods goods = service.select(id);
        return goods;
    }

    /**
     * 修改商品，方法使用PUT类型，通过访问 /goods 进行，根据主键进行修改，在请求的body中添加json格式数据。<br>
     * Integer id;主键id<BR/>
     * String goodName; 商品名称<BR/>
     * BigDecimal price; 商品价格<BR/>
     *
     * @param goods
     * @return
     */
    @RequestMapping(value = "/goods", method = RequestMethod.PUT)
    public String updateGoods(@RequestBody Goods goods) {
        goods.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        service.update(goods);
        return "update goods success";
    }

    /**
     * 删除商品，方法使用DELETE类型，通过访问 /goods/{id} 进行，根据主键进行删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.DELETE)
    public String deleteGoods(@PathVariable Integer id) {
        service.delete(id);
        return "delete goods success";
    }

}
