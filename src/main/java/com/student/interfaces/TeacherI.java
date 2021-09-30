package com.student.interfaces;

import com.student.models.Teacher;

public interface TeacherI extends CrudI<Teacher> {
    Teacher getTeacher(String email);
}
