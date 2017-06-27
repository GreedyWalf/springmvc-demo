package test.apache.poi;

/**
 * Created by QinYupeng on 2017/6/27.
 */
public class CourseInfo {
    private String courseId;
    private String courseTitle;
    private String courseCode;
    private Double coursePeriod;
    private Double courseScore;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Double getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(Double coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    public Double getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(Double courseScore) {
        this.courseScore = courseScore;
    }
}
