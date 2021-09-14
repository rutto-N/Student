package com.student.action;

import com.student.database.DbUtil;
import com.student.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterUserAction extends HttpServlet {
    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"./register\">add Student</a></li>" +
            "      <li ><a href=\"#\">view </a></li>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
            "      <li><a><button class=\"btn btn-danger navbar-btn\">Register</button></a></li>" +
            "      <li><a><button class=\"btn btn-success navbar-btn\">Login</button></a></li>" +
            "    </ul>" +
            "  </div>" +
            "</nav>";
    public static final String HEAD_LINK="<head><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n</head>";
    public static final String HTML_START="<html>"+HEAD_LINK+"<body>";
    public static final String HTML_END="</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display=resp.getWriter();
        display.println(HTML_START+""+NAVBAR);

        display.println("<div class=\"container \">\n" +
                "  <h2>Add Student Form</h2>\n" +
                "  <form action=\"./register\" method=\"POST\">\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"username\">Username:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"Enter username\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"email\">Email:</label>\n" +
                "      <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Enter email\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"password\">Password:</label>\n" +
                "      <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Enter password\">\n" +
                "    </div>\n" +
                "  <div class=\"form-group\">\n" +
                "      <label for=\"re-password\">Password:</label>\n" +
                "      <input type=\"password\" class=\"form-control\" id=\"re-password\" name=\"re-password\" placeholder=\"Enter password\">\n" +
                "    </div>\n" +
                "    <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
                "  </form>\n" +
                "</div>\n");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();
        display.println(HTML_START);

        display.println("<p>" + req.getParameter("username") + "" + req.getParameter("email") +
                req.getParameter("password") + "</p>");

        if (req.getParameter("password").equals(req.getParameter("re-password"))) {//confirm passwords match
            User user = new User();
            user.setEmail(req.getParameter("email"));
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));

            System.out.println(user);
            String sql = "INSERT INTO users(username,email,password) values('" + user.getUsername() + "'," +
                    "'" + user.getEmail() + "','" + user.getPassword() + "')";
            System.out.println(sql + "" + getServletContext().getAttribute("db"));

            DbUtil db = (DbUtil) getServletContext().getAttribute("db");


            db.execUpdate(sql);
            System.out.println("Added successfully");


        } else {
            display.println("<p>Passwords dont match<p/>");
        }


    }
}


