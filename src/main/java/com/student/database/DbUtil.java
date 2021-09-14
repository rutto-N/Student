package com.student.database;

import java.sql.*;

public class DbUtil {
    private Connection conn=null;


    public DbUtil() {
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getDbConnection() throws SQLException {


        return conn;

    }

    public ResultSet execQuery(String sql){
        if  (sql == null || sql.trim().equals(""))
            return null;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            return statement.executeQuery();

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }

        return null;

    }

    public boolean execUpdate(String sql){
        if  (sql == null || sql.trim().equals(""))
            return false;

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.executeUpdate();
            return true;

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
        return false;

    }

}
