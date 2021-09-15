package com.student.action.student;

import com.student.dao.StudentDao;
import com.student.database.DbUtil;
import com.student.enums.Gender;
import com.student.models.Student;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name="AddStudent",urlPatterns ="/student/add" )


public class AddStudentAction extends HttpServlet {

    public static final String NAVBAR="<nav class=\"navbar navbar-inverse\">" +
            "  <div class=\"container-fluid\">" +
            "    <div class=\"navbar-header\">" +
            "      <a class=\"navbar-brand\" href=\"#\">Student Management</a>" +
            "    </div>" +
            "    <ul class=\"nav navbar-nav\">" +
            "      <li ><a href=\"./\">Home</a></li>" +
            "      <li ><a href=\"../course/\">Courses</a></li>" +
            "      <li ><a href=\"../student/\">Students</a></li>" +
            "      <li ><a href=\"../users/\">Users</a></li>" +
            "    </ul>" +
            "       <ul class=\"nav navbar-nav navbar-right\">" +
            "      <li><a href=\"../logout\"><span class=\"glyphicon glyphicon-log-in\"></span>Logout</button></a></li>" +
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
        List<Gender> enums=new ArrayList<>();

        display.println("<div class=\"row \">\n" );


        display.println("<div class=\"col-md-4 col-md-offset-4\">\n" +
                "  <h2>Add Student </h2>\n" +
                "  <form class=\"form-horizontal\" action=\"./add\" method=\"POST\">\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"name\">Name:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"Enter name\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"email\">Email:</label>\n" +
                "      <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Enter email\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"dateOfBirth\">Date Of Birth:</label>\n" +
                "      <input type=\"date\" class=\"form-control\" id=\"dateOfBirth\" name=\"dateOfBirth\" placeholder=\"Enter date of birth\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">" +
                "    <label for=\"grade\">Academic year:</label>\n" +
                "    <select class=\"form-control\" name=\"grade\" id=\"grade\">\n" +
                "               <option disabled selected value=\"\">------Select Year-----</option>\n" +
                "               <option value=\"ONE\">1</option>\n" +
                "               <option value=\"TWO\">2</option>\n" +
                "               <option value=\"THREE\">3</option>\n" +
                "               <option value=\"FOUR\">4</option>\n" +
                "               </select>" +
                "   </div>" +
                "   <div class=\"form-group\">" +
                "    <label for=\"gender\">Gender:</label>\n" +
                "    <select class=\"form-control\" name=\"gender\" id=\"gender\">\n" +
                "               <option disabled selected value=\"\">------Select Gender------</option>\n" +
                "               <option value=\"MALE\">Male</option>\n" +
                "               <option value=\"FEMALE\">Female</option>\n" +
                "               </select>" +
                "   </div>" +
                "  <div class=\"form-group\">\n" +
                "      <label for=\"phoneNumber\">Phone Number:</label>\n" +
                "      <input type=\"number\" class=\"form-control\" id=\"phoneNumber\" name=\"phoneNumber\" placeholder=\"Enter phone number\">\n" +
                "    </div>\n" +
                "    <button type=\"submit\" class=\"btn btn-success\">Submit</button>\n" +
                "  </form>\n" +
                "</div></div>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        PrintWriter display = resp.getWriter();
        display.println(HTML_START);

        Student student=new Student();

        try {
            BeanUtils.populate(student,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(student);
        int addedBy= (int) session.getAttribute("id");


        StudentDao studentDao=new StudentDao();

        if (studentDao.add(student)){
            resp.sendRedirect("../student/view");
        }
        resp.sendRedirect("../student/add");





    }
}
