package com.qs.test.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.LastModified;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 测试：自定义Controller，如果阶乘AbstractController，这里可以在handleRequestInternal方法，完成页面的控制跳转；
 *  1. 继承AbstractController，先执行handleRequest方法，后执行handleRequestInternal方法；
 *  2. 可以直接通过respoonse相应文本内容到页面上；
 *  3. 可以通过response直接响应文本内容到页面；
 *
 * Created by Administrator on 2017/3/1.
 */
public class HelloAction extends AbstractController implements LastModified {
    //2. 在执行这个方法
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取url中参数
        String courseId = request.getParameter("courseId");
        ModelAndView modelAndView = new ModelAndView();
        //将参数只回设到页面
        modelAndView.addObject("courseId", courseId);
        //返回页面
        modelAndView.setViewName("/view/hello.jsp");
        return modelAndView;

        //3. 通过response直接相应文本输出到页面；
//        response.setCharacterEncoding("gb2312");
//        PrintWriter writer = response.getWriter();
//        writer.write("<b style='font:red;'>我是response对象响应的文本内容</b>");
//        return null;
    }

    //1. 会先执行这个方法
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //委托给WebContentGenerator进行缓存控制
        checkAndPrepare(request, response, this instanceof LastModified);

        //当前会话中是否应该串行化访问
        if(this.isSynchronizeOnSession()){
            HttpSession session = request.getSession(false);
            if(session == null){
                Object mutx = WebUtils.getSessionMutex(session);

            }
        }

        return super.handleRequest(request, response);
    }

    public long getLastModified(HttpServletRequest request) {
        return System.currentTimeMillis();
    }
}
