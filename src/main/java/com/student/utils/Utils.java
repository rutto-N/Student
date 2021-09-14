package com.student.utils;

import com.student.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

    public User resultSetToUser(ResultSet resultSet)
    {
        User user=new User();
        try {
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String email=resultSet.getString(3);
                user.setEmail(email);
                user.setUsername(name);
                user.setId(id);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;

    }
}
