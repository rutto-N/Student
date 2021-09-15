package com.student.models;

import java.io.Serializable;
import java.util.Arrays;

public class Teacher implements Serializable {
    private int teacherId;
    private String name;
    private String email;
    private String gender;
    private int phoneNumber;
    Course course;

    public Teacher() {
    }

    public Teacher(int teacherId, String name, String email, String gender, int phoneNumber, Course course) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.course = course;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
