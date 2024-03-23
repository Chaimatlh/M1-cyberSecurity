package application;

public class Course {
    private String courseId;
    private String coursePath;

    public Course(String courseId, String coursePath) {
        this.courseId = courseId;
        this.coursePath = coursePath;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCoursePath() {
        return coursePath;
    }

    public void setCoursePath(String coursePath) {
        this.coursePath = coursePath;
    }
}