package com.student.action.course;

import com.student.dao.CourseDao;
import com.student.database.DbUtil;
import com.student.models.Course;
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

@WebServlet(
        name="AddCourse",
        urlPatterns ="/course/add"
)


public class AddCourse extends HttpServlet {
    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"../student/add\">add Student</a></li>" +
            "      <li ><a href=\"../student/view\">view </a></li>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
//            "      <li><a><button class=\"btn btn-danger navbar-btn\">Register</button></a></li>" +
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

        display.println("<div class=\"col-md-4 col-md-offset-4 \">\n" +
                "  <h2>Add Student Form</h2>\n" +
                "  <form action=\"./add\" method=\"POST\">\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"courseAbbr\">Course Abbr:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"courseAbbr\" name=\"courseAbbr\" placeholder=\"Course Abbr eg MAT 101\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"courseName\">Course Title:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"courseName\" name=\"courseName\" placeholder=\"Course Title eg Mathematics\">\n" +
                "    </div>\n" +
                "    <button type=\"submit\" class=\"btn btn-success\">Submit</button>\n" +
                "  </form>\n" +
                "</div>\n");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        PrintWriter display = resp.getWriter();
        display.println(HTML_START);

        Course course=new Course();

        try {
            BeanUtils.populate(course,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        int userId= (int) session.getAttribute("id");
        System.out.println(userId);


        CourseDao courseDao=new CourseDao();
        if (courseDao.add(course)){
            resp.sendRedirect("../course/view");


        }
        resp.sendRedirect("./add");



    }
}
