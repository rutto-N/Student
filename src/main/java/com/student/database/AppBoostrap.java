package com.student.database;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppBoostrap implements ServletContextListener {

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
        String createCoursesTableSql="CREATE TABLE IF NOT EXISTS courses(courseId int auto_increment primary key," +
                "courseName varchar(255))";
        statement.executeUpdate(createCoursesTableSql);
        System.out.println("Creating users Table : " + createUsersTableSql);
    }
}
