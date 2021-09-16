package com.student.models;

import java.io.Serializable;
import java.util.List;

public class Exam extends Course implements Serializable {

    private int examId;
    private String examName;
    private List<Student> studentList;
    private String grade;

    public Exam(int examId, String examName, List<Student> studentList, String grade) {
        this.examId = examId;
        this.examName = examName;
        this.studentList = studentList;
        this.grade = grade;
    }

    public Exam(int courseId, String courseAbbr, String courseName, int examId, String examName, List<Student> studentList, String grade) {
        super(courseId, courseAbbr, courseName);
        this.examId = examId;
        this.examName = examName;
        this.studentList = studentList;
        this.grade = grade;
    }

    public Exam(int courseId,
                int examId, String examName, List<Student> studentList, String grade) {
        super(courseId);
        this.examId = examId;
        this.examName = examName;
        this.studentList = studentList;
        this.grade = grade;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", studentList=" + studentList +
                ", grade='" + grade + '\'' +
                '}';
    }
}
