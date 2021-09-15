package com.student.action.student;

import com.student.dao.StudentDao;
import com.student.models.Student;
import com.student.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (
        name="ViewStudents",
        urlPatterns ={"/student/view","/student/"}
)


public class ViewStudents extends HttpServlet {
    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"./add\">add Student</a></li>" +
            "      <li ><a href=\"./view\">View Students</a></li>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
//            "      <li><button class=\"btn btn-danger navbar-btn\">Register</button></li>" +
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
        StudentDao studentDao =new StudentDao();
        List<Student> studentList;
        studentList = studentDao.view();

        display.print("<div class=\"row \">");
        display.print("<div class=\"col-lg-8\" style={margin:10%;}>");

        display.print("<table class=\"table table-center table-hover table-responsive table-bordered\">");
        display.print("<caption class=\"text-center\">Students</caption>");
        display.print("<th class=\"text-center success\">Student ID</th>");
        display.print("<th class=\"text-center success\">Student Name</th>");
        display.print("<th class=\"text-center success\">Student Email</th>");
        display.print("<th class=\"text-center success\">Edit</th>");
        display.print("<th class=\"text-center success\">Delete</th>");


        for (Student student : studentList) {
            display.print("<tr>");
            display.print("<td>" +student.getStudentId() + "</td>");
            display.print("<td>" +student.getName() + "</td>");
            display.print("<td>" +student.getEmail() + "</td>");
            display.print("<td><button id=\"\" class=\"btn btn-success btn-sm \">Edit</button></td>");
            display.print("<td><button id=\"\" class=\"btn btn-danger btn-sm text-center\">Delete</button>" +
                    "</td>");

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



