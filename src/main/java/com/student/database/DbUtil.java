package com.student.database;


import java.sql.*;

public class DbUtil {

    private Connection conn;
    PreparedStatement statement;

    public DbUtil() {
        try {
            conn = getDbConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getDbConnection() throws SQLException {

        conn = DataS.getInstance().getConnection();

        return conn;

    }

    public ResultSet execQuery(String sql) {
        if (sql == null || sql.trim().equals(""))
            return null;

        try {
            statement = conn.prepareStatement(sql);
            return statement.executeQuery(sql);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return null;

    }

    public boolean execUpdate(String sql) {
        if (sql == null || sql.trim().equals(""))
            return false;

        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate(sql);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return false;

    }

    public void closeConnection() {
        try {
            if (conn != null && statement != null) {
                statement.close();
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this.closeConnection();

    }
}
