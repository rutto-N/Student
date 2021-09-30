package com.student.models;

import java.io.Serializable;

public class EnrolmentDetail implements Serializable {
    private int enrolmentId;
    private String studentName;
    private String courseName;


    public EnrolmentDetail() {
    }

    public EnrolmentDetail(int enrolmentId, String studentName, String courseName) {
        this.enrolmentId = enrolmentId;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "EnrolmentDetail{" +
                "studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
