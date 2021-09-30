package com.student.models;

import java.io.Serializable;

public class Mark implements Serializable {
    int examId;
    int score;
    int studentId;

    public Mark() {
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "examId=" + examId +
                ", score=" + score +
                ", studentId=" + studentId +
                '}';
    }
}
