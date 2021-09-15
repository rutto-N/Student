package com.student.dao;

import com.student.CrudI;
import com.student.models.Teacher;

import java.util.List;

public class TeacherDao implements CrudI<Teacher> {
    @Override
    public boolean add(Teacher teacher) {

        return false;
    }

    @Override
    public List<Teacher> view() {
        return null;
    }

    @Override
    public boolean delete(Teacher teacher) {
        return false;
    }
}
