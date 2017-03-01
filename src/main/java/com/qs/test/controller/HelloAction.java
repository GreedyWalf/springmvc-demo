package com.qs.test.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/1.
 */
public class HelloAction implements Controller {
    //只要请求符合要求（.action 根据配置）配置文件中的bean都会被创建，他们是单例的，下次访问就不会再创建了
    public HelloAction(){
        System.out.println("创建实例：--> HelloAction");
    }

    //每次页面刷新都会执行handlerRequest方法
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","这是我的第一个SpringMvc应用程序");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
