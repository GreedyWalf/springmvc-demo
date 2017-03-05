package com.qs.test6.controller;

import com.sun.beans.editors.BooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsAction {
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder dataBinder) {
        //设置字符串时间转换为Date类型时间 并封装到实体中
        dataBinder.registerCustomEditor(Goods.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss"), true));

        //设置字符串转换为Boolean类型 并封装到实体中
        dataBinder.registerCustomEditor(Goods.class,new BooleanEditor());
    }

    /**
     * 通过initBinder注解 将页面传过来的参数值封装到对应的实体 方便后端取到页面传过来的值
     *
     * @param model  model是一个map，通过modal.get("goods")可以获取表单对应的实体
     * @param goods  页面表单对应的实体
     */
    @RequestMapping(value = "/saveGoods")
    public String saveGoods(Model model, Goods goods) {
        System.out.println("goodsName=" + goods.getGoodsName());
        System.out.println("count=" + goods.getCount());
        System.out.println("productDate=" + goods.getProductDate());
        System.out.println("isStandard=" + goods.getStandard());

        model.addAttribute("message","保存商品成功！");
        return "success";
    }
}
