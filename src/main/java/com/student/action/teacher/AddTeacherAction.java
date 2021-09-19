package com.student.action.teacher;

import com.student.dao.TeacherDao;
import com.student.dao.UserDao;
import com.student.models.Teacher;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

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
        resp.sendRedirect("../add-teacher.jsp");

//        display.println("<div class=\"row \">\n" );
//        display.println("<div class=\"col-md-4 col-md-offset-4\">\n" +
//                "  <h2>Add Teacher </h2>\n" +
//                "  <form class=\"form-horizontal\" action=\"./add\" method=\"POST\">\n" +
//                "    <div class=\"form-group\">\n" +
//                "      <label for=\"name\">Name:</label>\n" +
//                "      <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"Enter name\">\n" +
//                "    </div>\n" +
//                "    <div class=\"form-group\">\n" +
//                "      <label for=\"email\">Email:</label>\n" +
//                "      <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Enter email\">\n" +
//                "    </div>\n" +
//                "    <div class=\"form-group\">" +
//                "    <label for=\"courseId\">Course:</label>\n" +
//                "    <select class=\"form-control\" name=\"courseId\" id=\"courseId\">\n" +
//                "               <option disabled selected value=\"\">------Select Course-----</option>\n" +
//                "               <option value=\"1\">MATH 101</option>\n" +
//                "               <option value=\"7\">MATH 102</option>\n" +
//                "               <option value=\"5\">SCI 101</option>\n" +
//                "               <option value=\"6\">KIS 101</option>\n" +
//                "               <option value=\"3\">ENG 101</option>\n" +
//                "               </select>" +
//                "   </div>" +
//                "   <div class=\"form-group\">" +
//                "    <label for=\"gender\">Gender:</label>\n" +
//                "    <select class=\"form-control\" name=\"gender\" id=\"gender\">\n" +
//                "               <option disabled selected value=\"\">------Select Gender------</option>\n" +
//                "               <option value=\"MALE\">Male</option>\n" +
//                "               <option value=\"FEMALE\">Female</option>\n" +
//                "               </select>" +
//                "   </div>" +
//                "  <div class=\"form-group\">\n" +
//                "      <label for=\"phoneNumber\">Phone Number:</label>\n" +
//                "      <input type=\"number\" class=\"form-control\" id=\"phoneNumber\" name=\"phoneNumber\" placeholder=\"Enter phone number\">\n" +
//                "    </div>\n" +
//                "    <button type=\"submit\" class=\"btn btn-success\">Submit</button>\n" +
//                "  </form>\n" +
//                "</div></div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display= resp.getWriter();
        Teacher teacher=new Teacher();
        try {
            BeanUtils.populate(teacher,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(teacher);

        TeacherDao teacherDao = new TeacherDao();

        if (teacherDao.add(teacher)) {
            UserDao userDao=new UserDao();
            if (userDao.add(teacher))
                resp.sendRedirect("../view-students.jsp");
            else
                System.out.println("something went wrong");
       }
        resp.sendRedirect("../add-teacher.jsp");




    }
}
