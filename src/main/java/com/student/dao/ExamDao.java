package com.student.dao;

import com.student.interfaces.CrudI;
import com.student.models.Exam;

import java.util.List;

public class ExamDao implements CrudI<Exam> {
    @Override
    public boolean add(Exam exam) {
        return false;
    }

    @Override
    public List<Exam> view() {
        return null;
    }

    @Override
    public boolean delete(Exam exam) {
        return false;
    }




}
