package com.student.database;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSource {

    private static javax.sql.DataSource ds;

    private MysqlDataSource mysqlDs =  new MysqlDataSource();

    private DataSource(){
        mysqlDs.setUrl("jdbc:mysql://localhost:3306/sms");
        mysqlDs.setUser("root");
        mysqlDs.setPassword("");

    }

    public static javax.sql.DataSource getInstance(){
        if (ds == null)
            ds = new com.student.database.DataSource().getMysqlDs();

        return ds;
    }

    public MysqlDataSource getMysqlDs() {
        return mysqlDs;
    }

    public void setMysqlDs(MysqlDataSource mysqlDs) {
        this.mysqlDs = mysqlDs;
    }

}