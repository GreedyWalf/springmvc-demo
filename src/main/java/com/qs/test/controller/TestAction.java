package com.qs.test.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 测试：ajax请求，测试时post请求，实现LastModified接口，并没有在响应的请求中看到修改时间。。（问题）
 *
 * Created by QinYupeng on 2017/7/2.
 */
public class TestAction extends AbstractController implements LastModified  {
    private long lastModified;

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("gb2312");
        PrintWriter writer = response.getWriter();
        writer.write(request.getParameter("courseId") + new Date().getTime());
        writer.flush();
        return null;
    }

    //继承LastModified接口，实现response响应请求时，会带上最后修改时间一起返回；
    public long getLastModified(HttpServletRequest request) {
        if (lastModified == 0L) {
            lastModified = System.currentTimeMillis();
        }

        return lastModified;
    }
}
