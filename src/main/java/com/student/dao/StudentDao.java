package com.student.dao;

import com.student.CrudI;
import com.student.database.DbUtil;
import com.student.models.Student;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends DbUtil implements CrudI<Student> {
    @Override
    public boolean add(Student student) {
        String sql="INSERT INTO students(name,email,grade,phone) VALUES ('"+student.getName()+"','"+
                student.getEmail()+"','" + student.getGrade()+"',"+student.getPhoneNumber()+")";
        System.out.println(sql);

        return execUpdate(sql);
    }

    @Override
    public List<Student> view() {

        List<Student> studentList=new ArrayList<>();
        String sql = "SELECT * FROM students";
        ResultSet rs=execQuery(sql);
        try{
            while (rs.next()) {

                Student student = new Student();
                student.setStudentId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setDateOfBirth(rs.getString(4));
                student.setGrade(rs.getString(5));
                student.setPhoneNumber(rs.getInt(6));



                studentList.add(student);

            }
        }catch (Exception e){
            e.getMessage();

        }

        return studentList;
    }
}
