package com.student.models;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private int studentId;
    private String name;
    private String email;
    private String dateOfBirth;
    private  Date regDate;
    private String grade;
    private int phoneNumber;

    public Student(){
    }

    public Student(String name, String email, String grade, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
    }

    public Student(int studentId, String name, String email, String dateOfBirth,
                   Date regDate, String grade, int phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.regDate = regDate;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", regDate=" + regDate +
                ", grade='" + grade + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
