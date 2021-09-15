package com.student.action.course;

import com.student.dao.CourseDao;
import com.student.dao.UserDao;
import com.student.models.Course;
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
        name="ViewCourses",
        urlPatterns ={"/course/view","/course/"}
)

public class ViewCourse extends HttpServlet {

    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"../student/add\">add Student</a></li>" +
            "      <li ><a href=\"./view\"> Courses</a></li>" +
            "      <li ><a href=\"./add\"> Add Course</a></li>" +
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

        CourseDao courseDao =new CourseDao();
        List<Course> courseList;
        courseList = courseDao.view();
        display.print("<div class=\"row \">");
        display.print("<div class=\"col-lg-8\" style={margin:10%;}>");

        display.print("<table class=\"table center table-hover table-responsive table-bordered\">");
        display.print("<caption class=\"text-center\">Courses</caption>");
        display.print("<th class=\"text-center success\">Course Id</th>");
        display.print("<th class=\"text-center success\">Course ABBR</th>");
        display.print("<th class=\"text-center success\">Course Title</th>");
        display.print("<th class=\"text-center success\">Edit</th>");
        display.print("<th class=\"text-center success\">Delete</th>");


        for (Course course : courseList){
            display.print("<tr>");
            display.print("<td>" + course.getCourseId() + "</td>");
            display.print("<td>" + course.getCourseAbbr() + "</td>");
            display.print("<td>" + course.getCourseName() + "</td>");
            display.print("<td><button id=\"\" class=\"btn btn-success btn-sm \">Edit</button></td>");
            display.print("<td><button id=\"\" class=\"btn btn-danger btn-sm text-center\">Delete</button></td>");
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
