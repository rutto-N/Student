package com.student.database;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebListener

public class AppBootstrap implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            DbUtil db = new DbUtil();
            System.out.println("Connection Established");

            this.createTables(db.getDbConnection());
            ServletContext sc = sce.getServletContext();
            sc.setAttribute("db", db);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private void createTables(Connection connection) throws SQLException {
        String createUsersTableSql = "CREATE TABLE IF NOT EXISTS users(id int auto_increment primary key," +
                "username varchar(255), email varchar(255), password varchar(255))";
        PreparedStatement statement = connection.prepareStatement(createUsersTableSql);
        statement.executeUpdate();
        String createCoursesTableSql = "CREATE TABLE IF NOT EXISTS courses(courseId int auto_increment primary key,courseAbrr varchar (255)," +
                "courseName varchar(255),userId int(11))";
        statement.executeUpdate(createCoursesTableSql);

        String createStudentsTableSql = "CREATE TABLE IF NOT EXISTS students(studentId int auto_increment primary key," +
                "name varchar(255),email varchar(255),dob varchar(255),grade varchar(255),phone int (11),userId int (11))";
        statement.executeUpdate(createStudentsTableSql);

        String createTeachersTableSql = "CREATE TABLE IF NOT EXISTS teachers(teacherId int auto_increment primary key," +
                "name varchar(255),email varchar(255),gender varchar(255),phone int (11),courseId int (11),userId int (11))";
        statement.executeUpdate(createTeachersTableSql);

    }
}
