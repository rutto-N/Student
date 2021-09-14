package com.student.dao;

import com.student.CrudI;
import com.student.database.AppBoostrap;
import com.student.database.DbUtil;
import com.student.models.User;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.util.List;

public class UserDao extends DbUtil implements CrudI<User>{

    static DbUtil dbUtil;

    @Override
    public boolean add(User user) {
        String name= user.getUsername();
        String email= user.getEmail();
        String password= user.getPassword();

        String sql = "INSERT INTO users(username,email,password) values('" +name + "'," +
                "'" + email + "','" + password + "')";
        dbUtil.execUpdate(sql);


        return false;
    }

    @Override
    public List<User> view() {
        return null;
    }
}
