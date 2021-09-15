package com.student.action.auth;

import com.student.dao.UserDao;
import com.student.models.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;


@WebServlet(name="Register",urlPatterns ="/register" )

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
            "      <li><a href=\"./login\"><button class=\"btn btn-md btn-danger navbar-btn\">Login</button></a></li>" +
//            "      <li><a href=\"./logout\"><button class=\"btn btn-danger navbar-btn\">Logout</button></a></li>" +
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

        display.println("<div class=\"container col-md-4 col-md-offset-4 \">\n" +
                "  <h2>Registration Form</h2>\n" +
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
                "    <button type=\"submit\" class=\"btn btn-success\">Submit</button>\n" +
                "  </form>\n" +
                "</div>\n");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();
        display.println(HTML_START);
        if (req.getParameter("password").trim().equals
                (req.getParameter("re-password").trim())) {//confirm passwords match
            User user = new User();
            try {
                BeanUtils.populate(user,req.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserDao userDao=new UserDao();
            if (userDao.add(user)){
                System.out.println("Added successfully");
                resp.sendRedirect("./login");
            }else
                resp.sendRedirect("./register");

        }




    }
}


