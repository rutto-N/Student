package com.student.models;

import java.io.Serializable;

public class Unit implements Serializable {
    private int courseId;
    private String courseAbbr;
    private String courseName;
    private String gradeId;
    private String course;

    public Unit() {
    }

    public Unit(int courseId, String courseAbbr, String courseName, String gradeId, String course) {
        this.courseId = courseId;
        this.courseAbbr = courseAbbr;
        this.courseName = courseName;
        this.gradeId = gradeId;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
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
                ", gradeId=" + gradeId +
                '}';
    }
}
