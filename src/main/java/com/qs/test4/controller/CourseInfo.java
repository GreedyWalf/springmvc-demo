package com.qs.test4.controller;

import java.util.Date;

/**
 * 创建实体类
 */
public class CourseInfo {
    private String courseTitle;
    private Date startTime;

    public CourseInfo(){}

    public CourseInfo(String courseTitle, Date startTime) {
        this.courseTitle = courseTitle;
        this.startTime = startTime;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
