package com.student.interfaces;

import com.student.models.Student;

import java.util.List;

public interface StudentI extends CrudI<Student> {
    List<Student> getStudentsByGrade(String grade);

    Student getStudent(String email);
}
