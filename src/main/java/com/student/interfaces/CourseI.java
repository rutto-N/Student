package com.student.interfaces;

import com.student.models.Unit;

import java.util.List;

public interface CourseI extends CrudI<Unit> {
    List<Unit> getCoursesByGrade(String grade);
}
