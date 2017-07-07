package com.qs.test.controller;

import com.qs.test.model.UserModel;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.BaseCommandController;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试：继承BaseCommandController的子类，实现请求参数的数据绑定实体；
 *
 * Created by QinYupeng on 2017/7/2.
 */
public class CommandController extends AbstractCommandController {
    //1. 构造方法中绑定自定义pojo类接收参数数据绑定；
    public CommandController(){
        System.out.println("--->>> 构造方法");
        this.setCommandClass(UserModel.class);
    }

    //2. 自定义转换器，initBinder方法将页面传过来的时间字符串，转换为Date类型数据，并封装到实体中；
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        System.out.println("--->>>> initBinder");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    //3.  获取和处理封装的实体数据 并控制页面跳转 command对象为封装好请求参数数据的实体
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        System.out.println("--->>> handle");
        UserModel userModel = (UserModel) command;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/view/hello.jsp");
        modelAndView.addObject("userModel", userModel);
        return modelAndView;
    }
}