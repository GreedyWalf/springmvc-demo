package com.qs.test.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by QinYupeng on 2017/7/2.
 */
@Controller
public class OrderController {
    @RequestMapping("/orderIndex")
    public ModelAndView showIndex(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","this is annotation msg!");
        modelAndView.setViewName("/view/hello.jsp");
        return modelAndView;
    }

}
