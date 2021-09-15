package com.student.dao;

import com.student.CrudI;
import com.student.database.DbUtil;
import com.student.models.Course;
import com.student.models.Teacher;
import com.student.models.User;

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
        ResultSet rs=execQuery(sql);
        try{
            while (rs.next()) {

                Course course = new Course();

                        course.setCourseId(rs.getInt(1));
                        course.setCourseAbbr(rs.getString(2));
                        course.setCourseName(rs.getString(3));

                courseList.add(course);

            }
        }catch (Exception e){
            e.getMessage();

        }

        return courseList;
    }
}
