package com.student.database;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataS {

    private static DataSource ds;

    private DataSource dataSource;

    private DataS() {

        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/sms");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
//singleton class
    public static DataSource getInstance() {
        if (ds == null)
            ds = new DataS().getDataSource();

        return ds;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}