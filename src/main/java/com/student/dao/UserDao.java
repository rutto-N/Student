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
        String name= user.getUsername();
        String email= user.getEmail();
        String password= user.getPassword();
        System.out.println(name+","+email+"."+password);

        String sql = "INSERT INTO users(username,email,password) values('" +name + "'," +
                "'" + email + "','" + PasswordEncrypt.encryptText(user.getPassword()) + "')";
        System.out.println(sql);
        boolean result=execUpdate(sql);

        return result;
    }

    @Override
    public List<User> view() {
        List<User> userList=new ArrayList<>();
        String sql = "SELECT * FROM users";
        ResultSet rs=execQuery(sql);
        try{
            while (rs.next()) {

                User user = new User(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                userList.add(user);

            }
        }catch (Exception e){
            e.getMessage();

        }
        return userList;


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
