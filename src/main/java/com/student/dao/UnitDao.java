package com.student.dao;

import com.student.database.DbUtil;
import com.student.interfaces.CourseI;
import com.student.models.Unit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UnitDao extends DbUtil implements CourseI {

    @Override
    public boolean add(Unit unit) {
        String sql = "INSERT INTO courses(courseAbbr,courseName,gradeId,course) values('" + unit.getCourseAbbr() + "'," +
                "'" + unit.getCourseName() + "','" + unit.getGradeId() + "','"+ unit.getCourse() +"')";
        System.out.println(sql);

        return execUpdate(sql);
    }

    @Override
    public List<Unit> view() {
        List<Unit> unitList = new ArrayList<>();

        String sql = "SELECT * FROM courses WHERE status='ACTIVE'";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Unit unit = new Unit();

                unit.setCourseId(resultSet.getInt(1));
                unit.setCourseAbbr(resultSet.getString(2));
                unit.setCourseName(resultSet.getString(3));

                unitList.add(unit);

            }
        } catch (Exception e) {
            e.getMessage();

        }

        return unitList;
    }
    @Override
    public List<Unit> getCoursesByGrade(String grade) {
        List<Unit> unitList = new ArrayList<>();
        String sql = "SELECT * FROM courses WHERE status='ACTIVE' AND gradeId='"+grade+"'";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Unit unit = new Unit();

                unit.setCourseId(resultSet.getInt(1));
                unit.setCourseAbbr(resultSet.getString(2));
                unit.setCourseName(resultSet.getString(3));
                unit.setGradeId(resultSet.getString(4));


                unitList.add(unit);

            }
        } catch (Exception e) {
            e.getMessage();

        }

        return unitList;
    }
    public List<Unit> getUnitsByGradeAndCourse(String grade,String course) {
        List<Unit> unitList = new ArrayList<>();
        String sql = "SELECT * FROM courses WHERE status='ACTIVE' AND gradeId='"+grade+"' AND course='"+course+"'";
        ResultSet resultSet = execQuery(sql);
        try {
            while (resultSet.next()) {

                Unit unit = new Unit();

                unit.setCourseId(resultSet.getInt(1));
                unit.setCourseAbbr(resultSet.getString(2));
                unit.setCourseName(resultSet.getString(3));
                unit.setGradeId(resultSet.getString(4));


                unitList.add(unit);

            }
        } catch (Exception e) {
            e.getMessage();

        }

        return unitList;
    }

    @Override
    public boolean delete(Unit unit) {
        String sql = "UPDATE `courses` SET `status`='INACTIVE' WHERE courseId=" + unit.getCourseId();
        return execUpdate(sql);
    }




}


