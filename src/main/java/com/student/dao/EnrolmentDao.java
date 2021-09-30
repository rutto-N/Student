package com.student.dao;

import com.student.database.DbUtil;
import com.student.interfaces.EnrolmentI;
import com.student.models.Enrolment;
import com.student.models.EnrolmentDetail;
import com.student.models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentDao extends DbUtil implements EnrolmentI {


    @Override
    public boolean add(Enrolment enrolment) {
        String sql = "INSERT INTO `enrolments`(`courseId`, `studentId`, `teacherId`) VALUES ('" + enrolment.getCourseId() + "'," +
                "'" + enrolment.getStudentId() + "','" + enrolment.getTeacherId() + "')";
        System.out.println(sql);

        return execUpdate(sql);
    }

    @Override
    public List<Enrolment> view() {
        List<Enrolment> enrolments = new ArrayList<>();
        String sql = "SELECT students.name,courses.courseAbbr FROM students" +
                "INNER JOIN enrolments ON enrolments.studentId=students.studentId" +
                "INNER JOIN courses ON courses.courseId=enrolments.courseId` WHERE enrolments.status='ACTIVE' ";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Enrolment enrolment = new Enrolment();


                enrolment.setCourseId(resultSet.getInt(2));
                enrolment.setStudentId(resultSet.getInt(3));
                enrolment.setTeacherId(resultSet.getInt(4));

                enrolments.add(enrolment);

            }
        } catch (Exception e) {
            e.getMessage();

        }


        return enrolments;
    }

    @Override
    public List<EnrolmentDetail> viewEnrolments() {
        List<EnrolmentDetail> enrolments = new ArrayList<>();
        String sql = "SELECT enrolments.enrolmentId,students.name,courses.courseAbbr FROM students INNER JOIN " +
                "enrolments ON enrolments.studentId=students.studentId INNER JOIN " +
                "courses ON courses.courseId=enrolments.courseId WHERE enrolments.status='ACTIVE' ";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                EnrolmentDetail enrolmentDetail = new EnrolmentDetail();


                enrolmentDetail.setEnrolmentId(resultSet.getInt(1));
                enrolmentDetail.setStudentName(resultSet.getString(2));
                enrolmentDetail.setCourseName(resultSet.getString(3));

                enrolments.add(enrolmentDetail);

            }
        } catch (Exception e) {
            e.getMessage();

        }


        return enrolments;
    }
    @Override
    public List<EnrolmentDetail> viewEnrolmentsPerStudent(int studentId) {
        List<EnrolmentDetail> enrolments = new ArrayList<>();
        String sql = "SELECT enrolments.enrolmentId,students.name,courses.courseName FROM students INNER JOIN " +
                "enrolments ON enrolments.studentId=students.studentId INNER JOIN " +
                "courses ON courses.courseId=enrolments.courseId WHERE enrolments.status='ACTIVE'" +
                "AND enrolments.studentId="+studentId;
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                EnrolmentDetail enrolmentDetail = new EnrolmentDetail();


                enrolmentDetail.setEnrolmentId(resultSet.getInt(1));
                enrolmentDetail.setStudentName(resultSet.getString(2));
                enrolmentDetail.setCourseName(resultSet.getString(3));

                enrolments.add(enrolmentDetail);

            }
        } catch (Exception e) {
            e.getMessage();

        }


        return enrolments;
    }

    @Override
    public boolean delete(Enrolment enrolment) {
        String sql = "UPDATE `enrolments`SET `status`='INACTIVE' WHERE enrolmentId=" + enrolment.getEnrolmentId();
        return execUpdate(sql);
    }

    @Override
    public boolean checkEnrolled(Enrolment enrolment) {

        String sql = "SELECT * FROM `enrolments` WHERE courseId=" + enrolment.getCourseId() +
                " AND studentId=" + enrolment.getStudentId() +" AND status='ACTIVE'";

        ResultSet resultSet = execQuery(sql);


        try {
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    @Override
    public List<Student> getEnrolledStudentsByCourse(int courseId){
        System.out.println("-----------------------");
        String sql="SELECT studentId FROM `enrolments` WHERE courseId="+courseId;
        System.out.println(sql);

        List<Student> studentList = new ArrayList<>();

        ResultSet resultSet=execQuery(sql);

            try {
                System.out.println("-----------------------");

                while (resultSet.next()){
                    Student student=new Student();
                    student.setStudentId(resultSet.getInt("studentId"));
                    studentList.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return studentList;


    }
}


