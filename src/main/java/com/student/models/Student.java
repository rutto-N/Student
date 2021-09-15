package com.student.models;

import com.student.enums.Gender;
import com.student.enums.Grade;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private int studentId;
    private String name;
    private String email;
    private String dateOfBirth;
    private String gender;
    private String grade;
    private int phoneNumber;

    public Student(){
    }

    public Student(int studentId, String name, String email, String dateOfBirth, String gender, String grade, int phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
