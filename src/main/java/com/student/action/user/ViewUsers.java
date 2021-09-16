package com.student.action.user;

import com.student.dao.UserDao;
import com.student.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name="ViewUsers",
        urlPatterns ={"/users/view","/users/"}
)
public class ViewUsers extends HttpServlet {
    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./view\">Home</a></li>" +
            "      <li ><a href=\"../student/add\">add Student</a></li>" +
            "      <li ><a href=\"../student/\">View Students</a></li>" +
            "<form class=\"navbar-form navbar-left\" action=\"./search\" method=\"POST\">\n" +
            "      <div class=\"form-group\">\n" +
            "        <input type=\"text\" name=\"search\" class=\"form-control\" placeholder=\"name\">\n" +
            "      </div>" +
            "  <button type=\"submit\" class=\"btn btn-default\">Search</button></form>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
            "      <li><a href=\"../logout\"><button class=\"btn btn-danger navbar-btn\">Logout</button></a></li>" +
            "    </ul>" +
            "  </div>" +
            "</nav>";
    public static final String HEAD_LINK="<head><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n</head>";
    public static final String HTML_START="<html>"+HEAD_LINK+"<body>";
    public static final String HTML_END="</body></html>";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display= resp.getWriter();
        display.println(HTML_START+""+NAVBAR);

        UserDao userDao =new UserDao();
        List<User> users;
        users = userDao.view();
        display.print("<div class=\"row \">");
        display.print("<div class=\"col-md-8 col-md-offset-2\" style={margin:10%;}>");

        display.print("<table class=\"table center table-hover table-responsive table-bordered\">");
        display.print("<caption class=\"text-center\">Users</caption>");
//        display.print("<th class=\"text-center success\">User Id</th>");
        display.print("<th class=\"text-center success\">Username</th>");
        display.print("<th class=\"text-center success\">Email</th>");
        display.print("<th class=\"text-center success\">Edit</th>");
        display.print("<th class=\"text-center success\">Delete</th>");


        for (User user : users){
            display.print("<tr>");
//            display.print("<td>" + user.getId() + "</td>");
            display.print("<td>" + user.getUsername() + "</td>");
            display.print("<td>" + user.getEmail() + "</td>");
            display.print("<td><a><button class=\"btn btn-success btn-sm \">Edit</button></a></td>");
            display.print("<td><a href=\"../users/delete?id="+user.getId()+"\"><button class=\"btn btn-danger btn-sm text-center\">Delete</button></a></td>");
            display.print("</tr>");
        }

        display.print("</table>");
        display.print("</div");
        display.print("<div class=\"col-lg-2\"></div");
        display.print("</div>");

        display.println(HTML_END);


    }
    public void destroy() {
        System.out.println("Killing servlet....");
    }



}
