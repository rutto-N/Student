package com.student.action.auth;

import com.student.dao.UserDao;
import com.student.models.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name="Login",urlPatterns ="/login" )


public class SignInAction extends HttpServlet {
    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"./student/add\">add Student</a></li>" +
            "      <li ><a href=\"./view\">view </a></li>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
//            "      <li><a href=\"./register\"><button class=\"btn btn-danger navbar-btn\">Register</button></a></li>" +
//            "      <li><a href=\"./logout\"><button class=\"btn btn-danger btn-md navbar-btn\">Logout</button></a></li>" +
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

        display.println("<div class=\"card-body col-md-4 col-md-offset-4 \">\n" +
                "  <h2>Login Form</h2>\n" +
                "<hr>"+
                "  <form action=\"./login\" method=\"POST\">\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"email\">Email:</label>\n" +
                "      <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Enter email\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"password\">Password:</label>\n" +
                "      <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Enter password\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                " <h5>Dont have an account? <a href=\"./register\">Register</a></h5>"+
                "    </div>\n" +

                "    <button type=\"submit\" class=\"btn btn-success\">Login</button>\n" +
                "  </form>\n" +
                "</div>\n");


        req.getSession().invalidate();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        HttpSession session=req.getSession(true);


        if (!req.getParameter("email").isEmpty() && !req.getParameter("password").isEmpty()){
            User user=new User();

            try {
                BeanUtils.populate(user,req.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
          UserDao userDao=new UserDao();
            user=userDao.getUser(user);
            if (user!=null){
                session.setAttribute("id",user.getId());

                session.setAttribute("email",user.getEmail());
                resp.sendRedirect("./users/view");

            }else
                resp.sendRedirect("./login");


        }else {
            display.println("<p>Something went wrong Try again</p>");
            resp.sendRedirect("./login");
        }


    }
}
