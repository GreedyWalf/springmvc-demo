package com.qs.test4.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  执行顺序：
 *      1. CourseAction() 访问请求时创建Action实体，构造器中将页面数据分装到定义的实体对象中（name属性对应实体字段）
 *      2. initBinder() 将页面上的时间字符串装换为Date类型；
 *      3. handler() 处理数据并控制跳转到页面
 */
public class CourseAction extends AbstractCommandController {
    public CourseAction(){
        System.out.println("CourseAction实例生成了");
        //将表单中的数据封装到CourseInfo对象中去
        this.setCommandClass(CourseInfo.class);
    }


    //自定义转换器：将页面上传过来的时间字符串 转换为CourseInfo实体中Date类型数据，并封装到实体中
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        System.out.println("-->CourseAction initBinder()");
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    /**
     * 获取和处理封装的实体数据 并控制页面跳转
     * @param command  封装后的实体对象
     * @param errors  封装时产生的异常
     */
    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Object command, BindException errors) throws Exception {
        System.out.println("-->CourseAction handle()");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","课程信息添加成功");
        CourseInfo courseInfo = (CourseInfo) command;
        System.out.println("课程名称：" + courseInfo.getCourseTitle());
        System.out.println("学习时间：" + courseInfo.getStartTime().toLocaleString());
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
