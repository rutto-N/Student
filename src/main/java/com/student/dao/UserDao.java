package com.student.dao;

import com.student.CrudI;
import com.student.database.DbUtil;
import com.student.models.User;
import com.student.utils.PasswordEncrypt;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao  extends DbUtil implements CrudI<User>{

    @Override
    public boolean add(User user) {

        String sql = "INSERT INTO users(username,email,password) values('" + user.getUsername() + "'," +
                "'" + user.getEmail() + "','" + PasswordEncrypt.encryptText(user.getPassword()) + "')";
        System.out.println(sql+"Ddaaaaao");
        return execUpdate(sql);
    }

    @Override
    public List<User> view() {
        List<User> userList=new ArrayList<>();
        String sql = "SELECT * FROM users";
        ResultSet resultSet=execQuery(sql);
        try{
            while (resultSet.next()) {

                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));

                userList.add(user);

            }
        }catch (Exception e){
            e.getMessage();

        }
        return userList;


    }

    @Override
    public boolean delete(User user) {
        String sql="DELETE FROM users WHERE id="+user.getId();
        return execUpdate(sql);
    }

    public User getUser(User user){
        String sql="SELECT * FROM users WHERE email='"+user.getEmail()+"' " +
                "AND password='"+ PasswordEncrypt.encryptText(user.getPassword()) +"'";
        ResultSet rs=execQuery(sql);
        try{
            while (rs.next()) {

//
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));

                System.out.println(user);
                return user;
            }
        }catch (Exception e){
            e.getMessage();

        }
        return null;



    }
}
