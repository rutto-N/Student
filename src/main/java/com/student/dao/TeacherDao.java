package com.student.dao;

import com.student.database.DbUtil;
import com.student.interfaces.TeacherI;
import com.student.models.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends DbUtil implements TeacherI {
    @Override
    public boolean add(Teacher teacher) {

        String sql = "INSERT INTO `teachers`(`name`, `email`, `gender`, `phone`, `courseId`) " +
                "VALUES('" + teacher.getName() + "','" + teacher.getEmail() + "','" + teacher.getGender() + "'," +
                "'" + teacher.getPhoneNumber() + "','" + teacher.getCourseId() + "')";

        return execUpdate(sql);
    }

    @Override
    public List<Teacher> view() {

        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT * FROM teachers  WHERE status='ACTIVE'";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt(1));
                teacher.setName(resultSet.getString(2));
                teacher.setEmail(resultSet.getString(3));
                teacher.setGender(resultSet.getString(4));
//                teacher.setCourseName(resultSet.getString(7));
                teacherList.add(teacher);
                System.out.println(teacher);

            }
        } catch (Exception e) {
            e.getMessage();

        }

        return teacherList;
    }

    @Override
    public boolean delete(Teacher teacher) {
        return false;
    }
    @Override
    public Teacher getTeacher(String email){

        String sql="SELECT * FROM `teachers` WHERE email='"+email+"'";
        Teacher teacher = new Teacher();
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {


                teacher.setTeacherId(resultSet.getInt(1));
                teacher.setName(resultSet.getString(2));
                teacher.setEmail(resultSet.getString(3));
                teacher.setGender(resultSet.getString(4));
                teacher.setPhoneNumber(resultSet.getInt(5));
                teacher.setCourseId(resultSet.getInt(6));
                System.out.println(teacher);

            }
        } catch (Exception e) {
            e.getMessage();

        }


        return teacher;
    }






}
