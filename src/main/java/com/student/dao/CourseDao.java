package com.student.dao;

import com.student.interfaces.CrudI;
import com.student.database.DbUtil;
import com.student.models.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao extends DbUtil implements CrudI<Course> {

    @Override
    public boolean add(Course course) {
        String sql = "INSERT INTO courses(courseAbbr,courseName) values('" + course.getCourseAbbr()+ "','"+course.getCourseName()+"')";
        System.out.println(sql);

        return execUpdate(sql);
    }

    @Override
    public List<Course> view() {
        List<Course> courseList=new ArrayList<>();

        String sql="SELECT * FROM courses";
        ResultSet resultSet=execQuery(sql);
        try{
            while (resultSet.next()) {

                Course course = new Course();

                        course.setCourseId(resultSet.getInt(1));
                        course.setCourseAbbr(resultSet.getString(2));
                        course.setCourseName(resultSet.getString(3));

                courseList.add(course);

            }
        }catch (Exception e){
            e.getMessage();

        }


        return courseList;
    }
    @Override
    public boolean delete(Course course) {
        String sql="DELETE FROM courses WHERE courseId="+course.getCourseId();
        return execUpdate(sql);
    }






}


