package com.student.dao;

import com.student.interfaces.CrudI;
import com.student.database.DbUtil;
import com.student.models.Student;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends DbUtil implements CrudI<Student> {
    @Override
    public boolean add(Student student) {
        String sql="INSERT INTO students(name,email,grade,dob,gender,phone) VALUES ('"+student.getName()+"','"+
                student.getEmail()+"','" + student.getGrade()+"','"+student.getDateOfBirth()+"','"+student.getGender()+"',"+student.getPhoneNumber()+")";
        System.out.println(sql);

        return execUpdate(sql);
    }

    @Override
    public List<Student> view() {

        List<Student> studentList=new ArrayList<>();
        String sql = "SELECT * FROM students";
        ResultSet resultSet=execQuery(sql);
        try{
            while (resultSet.next()) {

                Student student = new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setEmail(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getString(4));
                student.setGrade(resultSet.getString(5));
                student.setGender(resultSet.getString(6));
                student.setPhoneNumber(resultSet.getInt(7));
                studentList.add(student);

            }
        }catch (Exception e){
            e.getMessage();

        }

        return studentList;
    }
    @Override
    public boolean delete(Student student) {
        String sql="DELETE FROM students WHERE studentId="+student.getStudentId();
        return execUpdate(sql);
    }

}


