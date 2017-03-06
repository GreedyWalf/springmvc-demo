package com.qs.test7.controller;

import com.qs.test6.controller.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 测试响应Json返回页面，包括javaBean转json；list转json；map转json；
 *
 * Created by Administrator on 2017/3/5.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsInfoAction {

    /**
     * 测试6： 异步发送表单数据到JavaBean，并将javaBean转换为json字符串响应到页面
     * 注意springMvc配置文件中的配置   <mvc:annotation-driven /> 不配置会报406错误
     */
    @RequestMapping(value = "saveGoodsInfo")
    public @ResponseBody Goods saveGoodsInfo(Goods goods) {
        System.out.println("goodsId=" + goods.getGoodsId());
        System.out.println("goodsName=" + goods.getGoodsName());
        System.out.println("count=" + goods.getCount());
        System.out.println("productDate=" + goods.getProductDate());
        System.out.println("isStandard=" + goods.getStandard());
        List<String> goodsIdList = new ArrayList<String>();
        goodsIdList.add("222222222222222");
        goodsIdList.add("111111111111111");
        goodsIdList.add("333333333333333");
        goodsIdList.add("444444444444444");
        goods.setGoodsIdList(goodsIdList);
        return goods;
    }

    //测试list转json
    @RequestMapping(value = "testList")
    public @ResponseBody List<Goods> testList2Json(Goods goods) {
        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods("111","这是商品名称","2010-10-10",5,true));
        list.add(new Goods("112","这是商品名称","2010-10-10",5,true));
        list.add(new Goods("113","这是商品名称","2010-10-10",5,true));
        return list;
    }


    //测试map转json
    @RequestMapping(value = "testMap")
    public @ResponseBody Map<String,String> testMap2Json(Goods goods) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("goodsName","这是商品名称");
        result.put("goodsId","11111111");
        return result;
    }

    /**
     * 测试7：根据业务方法名及参数名动态确定访问请求
     *
     *  /goods/testName.action
     */
    @RequestMapping(value="{name}")
    public @ResponseBody Goods testName(@PathVariable String name) {
        Goods goods = new Goods();
        goods.setGoodsId("110");
        goods.setGoodsName("aaaa");
        return goods;
    }
}
