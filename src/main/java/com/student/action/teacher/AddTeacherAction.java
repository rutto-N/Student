package com.student.action.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "AddTeacher",
        urlPatterns = "/teacher/add"
)
public class AddTeacherAction extends HttpServlet {
    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"../register\">add Student</a></li>" +
            "      <li ><a href=\"#\">view </a></li>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
//            "      <li><a href=\"./logout\"><button class=\"btn btn-danger navbar-btn\">Logout</button></a></li>" +
            "      <li><a href=\"../logout\"><button class=\"btn btn-danger navbar-btn\">Logout</button></a></li>" +
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
                "  <form action=\"./addTeacher\" method=\"POST\">\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"name\">Name:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"Enter name\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"email\">Email:</label>\n" +
                "      <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Enter email\">\n" +
                "    </div>\n" +
                "  <div class=\"form-group\">\n" +
                "      <label for=\"gender\">Gender:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"gender\" name=\"gender\" placeholder=\"Enter Gender\">\n" +
                "    </div>\n" +
                "  <div class=\"form-group\">\n" +
                "      <label for=\"phoneNumber\">Phone Number:</label>\n" +
                "      <input type=\"number\" class=\"form-control\" id=\"phoneNumber\" name=\"phoneNumber\" placeholder=\"Enter phone number\">\n" +
                "    </div>\n" +
                "    <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
                "  </form>\n" +
                "</div>\n");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
