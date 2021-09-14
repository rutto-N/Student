package com.student.database;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DbUtil {
    private Connection conn = null;
    private static DataSource dataSource;
    private MysqlDataSource mysqlDataSource = new MysqlDataSource();


    public DbUtil() {

        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/sms");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
    }


    public static DataSource getInstance() {
        if (dataSource == null)
            dataSource = new DbUtil().getMysqlDataSource();

        return dataSource;
    }

    public MysqlDataSource getMysqlDataSource() {
        return mysqlDataSource;
    }

    public void setMysqlDataSource(MysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }

    public Connection getDbConnection() throws SQLException {

        conn = getInstance().getConnection();

        return conn;

    }

    public ResultSet execQuery(String sql) {
        if (sql == null || sql.trim().equals(""))
            return null;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            return statement.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return null;

    }

    public boolean execUpdate(String sql) {
        if (sql == null || sql.trim().equals(""))
            return false;

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return false;

    }

}
