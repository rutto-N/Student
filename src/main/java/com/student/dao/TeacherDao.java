package com.student.dao;

import com.student.database.DbUtil;
import com.student.interfaces.CrudI;
import com.student.models.Teacher;

import java.util.List;

public class TeacherDao extends DbUtil implements CrudI<Teacher> {
    @Override
    public boolean add(Teacher teacher) {

        String sql="INSERT INTO `teachers`(`name`, `email`, `gender`, `phone`, `courseId`) " +
                "VALUES('"+teacher.getName()+"','"+teacher.getEmail()+"','"+teacher.getGender()+"'," +
                "'"+teacher.getPhoneNumber()+"','"+teacher.getCourseId()+"')";

        return execUpdate(sql);
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
