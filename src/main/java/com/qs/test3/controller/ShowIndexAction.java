package com.qs.test3.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowIndexAction extends AbstractController {

    //这里也可是继承类抽象类 实现Controller
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("执行了ShowIndexAction handleRequestInternal()");
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "这是后台传过来的数据");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
