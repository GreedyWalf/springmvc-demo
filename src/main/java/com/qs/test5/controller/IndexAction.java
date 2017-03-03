package com.qs.test5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解版本实现springMvc
 * 访问链接：http://localhost/springMvc/helloWorld.jsp
 *
 * Created by Administrator on 2017/3/3.
 */
@Controller
public class IndexAction {
    @RequestMapping("/helloWorld")
    public String index(Model model){
        model.addAttribute("message","这是用注解实现的springMvc");
//        return "/view/helloWorld.jsp";
        return "helloWorld";
    }
}
