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
import java.util.Arrays;

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
        dataBinder.registerCustomEditor(Goods.class, new BooleanEditor());
    }

    /**
     * 测试3：通过initBinder注解 将页面传过来的参数值封装到对应的实体 方便后端取到页面传过来的值
     *
     * @param model model是一个map，通过modal.get("goods")可以获取表单对应的实体
     * @param goods 页面表单对应的实体
     */
    @RequestMapping(value = "/saveGoods")
    public String saveGoods(Model model, Goods goods) {
        System.out.println("goodsName=" + goods.getGoodsName());
        System.out.println("count=" + goods.getCount());
        System.out.println("productDate=" + goods.getProductDate());
        System.out.println("isStandard=" + goods.getStandard());

        model.addAttribute("message", "保存商品成功！");
        return "success";
    }

    /**
     * 测试4：测试前台传递数组字符串，后台接收参数并封装为数组；
     *
     * @param goodsIds 前台传递过来的商品ID数组
     */
    @RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
    public String deleteGoods(String[] goodsIds, Model model) {
        System.out.println(Arrays.toString(goodsIds));
        model.addAttribute("message", "批量编辑商品成功");
        return "success";
    }

    /**
     * 测试5：结果转发和重定向
     */
    @RequestMapping(value = "/editGoods")
    public String editGoods(String goodsId) {
        System.out.println("编辑的商品id= " + goodsId);
        //请求转发 转发后的页面会获取所有的请求参数
        //return "forward:showEdit.action";

        //请求重定向  如果重定向后的页面需要参数 则这里需要带上参数
        return "redirect:showEdit.action?goodsId=" + goodsId;
    }

    /**
     * 当访问 /goods/editGoods.action?goodsId=01 通过转发会请求 /goods/showEdit.action?goodsId=01
     * 注意转发会将上一个请求的参数带上；重定向则需要在控制跳转时重新设置；
     *
     * @param goodsId  请求转发带的参数
     */
    @RequestMapping(value = "/showEdit")
    public String showEdit(String goodsId,Model model) {
        model.addAttribute("goodsId", goodsId);
        return "goods/saveGood";
    }
}
