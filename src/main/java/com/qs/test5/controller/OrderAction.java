package com.qs.test5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
