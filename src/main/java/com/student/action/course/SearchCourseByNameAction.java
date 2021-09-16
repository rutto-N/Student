package com.student.action.course;

import com.student.dao.CourseDao;
import com.student.models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "SearchCourseByName",
        urlPatterns = "course/search"
)
public class SearchCourseByNameAction extends HttpServlet {
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
            "<form class=\"navbar-form navbar-left\" action=\"./search\" method=\"POST\">\n" +
            "      <div class=\"form-group\">\n" +
            "        <input type=\"text\" name=\"search\"class=\"form-control\" placeholder=\"Type name here\">\n" +
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display= resp.getWriter();
        display.println(HTML_START);

        if (req.getParameter("search")!=null){
            CourseDao courseDao=new CourseDao();
            List<Course> courseList;
            courseList=courseDao.view();
            System.out.println(courseList);
            display.print("<div class=\"col-md-8 col-md-offset-2\" style={margin:10%;}>");

            display.print("<table class=\"table center table-hover table-responsive table-bordered\">");
            display.print("<caption class=\"text-center\">Courses</caption>");
//                display.print("<th class=\"text-center success\">Course Id</th>");
            display.print("<th class=\"text-center success\">Course ABBR</th>");
            display.print("<th class=\"text-center success\">Course Title</th>");
            display.print("<th class=\"text-center success\">Edit</th>");
            display.print("<th class=\"text-center success\">Delete</th>");
            display.print("<tr>");


            for (Course course:courseList) {

                if (course.getCourseName()!=null && course.getCourseName().toLowerCase().contains(req.getParameter("search").toLowerCase())
                        || course.getCourseName().equalsIgnoreCase(req.getParameter("search"))){
                    display.print("<div class=\"row \">");



//                    display.print("<td>" + course.getCourseId() + "</td>");
                    display.print("<td>" + course.getCourseAbbr() + "</td>");
                    display.print("<td>" + course.getCourseName() + "</td>");
                    display.print("<td><a><button id=\"\" class=\"btn btn-success btn-sm \">Edit</button></a></td>");
                    display.print("<td><a href=\"delete?id="+course.getCourseId()+"\"><button id=\"\" class=\"btn btn-danger " +
                            "btn-sm text-center\">Delete</button></a></td>");
                    display.print("</tr>");



            }
                }
            display.print("</table>");
            display.print("</div");
            display.print("<div class=\"col-lg-2\"></div");
            display.print("</div>");

            }



    }

}
