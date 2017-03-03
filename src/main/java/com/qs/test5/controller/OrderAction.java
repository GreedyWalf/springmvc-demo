package com.qs.test5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderAction {

    @RequestMapping("/addOrder")
    public String addOrder(Model model) {
        model.addAttribute("message", "增加订单");
        return "addOrder";
    }

    @RequestMapping(value = "/editOrder")
    public String editOrder(Model model) {
        model.addAttribute("message", "编辑订单");
        return "editOrder";
    }

    /**
     * 测试1：业务控制方法中通过方法中参数接收页面传递过来的值;
     * method = RequestMethod.POST 限制该方法只能post请求（貌似对ajax异步请求没啥用）；
     *
     * @param orderId 前端页面传递的参数
     */
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public String deleteOrder(Model model, String orderId) {
        System.out.println("orderId=" + orderId);
        model.addAttribute("msg", "删除订单成功！");
        return "success";
    }


}
