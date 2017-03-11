package com.qs.controller;

import com.qs.entity.user.UserInfo;
import com.qs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/7.
 */
@Controller
@RequestMapping(value = "/user")
public class UserAction {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/saveUser")
    public String saveUser(Model model){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("qs");
        userInfo.setSex("man");
        userInfo.setPhone("15856999769");
        userInfo.setCreateTime(new Date());

        userService.saveOrUpdate(userInfo);
        return "hello";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(Model model) {
        int userId = 3;
        userService.deleteByUserId(userId);
        return "hello";
    }

    @RequestMapping(value = "/getUser")
    public String getUser(Model model){
        int userId = 2;
//        UserInfo userInfo = userService.load(userId);
        UserInfo userInfo = userService.getEntity(userId);
        model.addAttribute("userInfo",userInfo);
        return "hello";
    }
}
