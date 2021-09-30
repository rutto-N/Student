package com.student.dao;

import com.student.database.DbUtil;
import com.student.interfaces.StudentI;
import com.student.models.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends DbUtil implements StudentI {

    @Override
    public boolean add(Student student) {

        String sql = "INSERT INTO students(name,email,grade,dob,gender,phone,course,userId) VALUES ('"
                + student.getName() +
                "','" + student.getEmail() +
                "','" + student.getGrade() +
                "','" + student.getDateOfBirth() +
                "','" + student.getGender() +
                "'," + student.getPhoneNumber() +
                "'," + student.getCourse() +
                "," + student.getCreatedBy() + ")";
        System.out.println(sql);

        return execUpdate(sql);
    }

    @Override
    public List<Student> view() {

        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE status='ACTIVE'";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Student student = new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setEmail(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getString(4));
                student.setGrade(resultSet.getString(5));
                student.setGender(resultSet.getString(6));
                student.setPhoneNumber(resultSet.getInt(7));
                student.setCourse(resultSet.getString(8));
                studentList.add(student);

            }
        } catch (Exception e) {
            e.getMessage();

        }
        return studentList;
    }
    @Override
    public List<Student> getStudentsByGrade(String grade) {

        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE status='ACTIVE' AND grade='"+grade+"'";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Student student = new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setEmail(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getString(4));
                student.setGrade(resultSet.getString(5));
                student.setGender(resultSet.getString(6));
                student.setPhoneNumber(resultSet.getInt(7));
                student.setCourse(resultSet.getString(8));
                studentList.add(student);

            }
        } catch (Exception e) {
            e.getMessage();

        }
        return studentList;
    }

    @Override
    public boolean delete(Student student) {
        String sql = "UPDATE `students` SET `status`='INACTIVE' WHERE studentId=" + student.getStudentId();
        return execUpdate(sql);
    }
    @Override
    public Student getStudent(String email){

        String sql="SELECT * FROM `students` WHERE email='"+email+"'";
        ResultSet resultSet=execQuery(sql);
        Student student = new Student();
        try{
            while (resultSet.next()) {

                student.setStudentId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setEmail(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getString(4));
                student.setGrade(resultSet.getString(5));
                student.setGender(resultSet.getString(6));
                student.setPhoneNumber(resultSet.getInt(7));
                student.setCourse(resultSet.getString(8));
            }

        }catch (Exception e){
            e.getMessage();
        }


        return student;
    }


}


