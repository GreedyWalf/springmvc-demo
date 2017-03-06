package com.qs.test5.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注解实现springMvc及数据传递和封装
 *
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


    /**
     * 测试2：通过传统的request和response对象 获取页面请求参数或相应数据到页面
     */
    @RequestMapping(value = "/saveOrder", method = RequestMethod.GET)
    public void saveOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //request获取页面传来的参数
        String orderName = request.getParameter("orderName");
        String orderId = request.getParameter("orderId");
        String orgUrl = request.getParameter("orgUrl");
        if(StringUtils.isBlank(orderName) || StringUtils.isBlank(orderId)){
            throw new Exception("parem orderName or orderId is null or empty");
        }

        System.out.println("orderName=" + orderName);
        System.out.println("orderId=" + orderId);

        //response响应请求，输出内容
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("<script>alert('保存成功');</script>");
        pw.write("<script>window.location.href=\"" + orgUrl + "\"</script>");
        pw.close();
    }
}
