package com.test.controller;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
@Controller
@RequestMapping("/test")
public class MyController {

    /**
     * 第一个映射到freemarker简单实例
     * 访问路径: http://localhost:8080/test/hello.do
     *
     * @return
     */
    @RequestMapping("/hello.do")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        modelAndView.addObject("mylist", list);
        return modelAndView;
    }

    /**
     * 访问表单页面
     *
     * @return
     */
    @RequestMapping("/testForm.do")
    public String testForm() {
        return "testForm";
    }

    /**
     * 获取表单参数 测试参数绑定
     *
     * @param name
     * @param age
     */
    @RequestMapping("/testBindFormData.do")
    public void testBindFormData(String name, Integer age) {
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("======================");
    }

//    @InitBinder
//    public void initBinder(ServletRequestDataBinder binder) {
//        binder.registerCustomEditor(Date.class,
//                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  //true表示允许为空
//    }
}
