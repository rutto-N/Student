package com.student.models;

import java.io.Serializable;

public class Course implements Serializable {
    private int courseId;
    private String courseAbbr;
    private String courseName;

    public Course() {
    }

    public Course(int courseId, String courseAbbr, String courseName) {
        this.courseId = courseId;
        this.courseAbbr = courseAbbr;
        this.courseName = courseName;
    }

    public Course(int courseId) {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAbbr() {
        return courseAbbr;
    }

    public void setCourseAbbr(String courseAbbr) {
        this.courseAbbr = courseAbbr;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseAbbr='" + courseAbbr + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
