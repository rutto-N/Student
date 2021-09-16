package com.student.action.student;

import com.student.dao.CourseDao;
import com.student.dao.StudentDao;
import com.student.models.Course;
import com.student.models.Student;

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
        name = "SearchByName",
        urlPatterns = "student/search"
)
public class SearchStudentByNameAction extends HttpServlet {
    public static final String NAVBAR = "<nav class=\"navbar navbar-inverse\">" +
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
    public static final String HEAD_LINK = "<head><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n</head>";
    public static final String HTML_START = "<html>" + HEAD_LINK + "<body>";
    public static final String HTML_END = "</body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();

        display.println(HTML_START);

        if (req.getParameter("search") != null) {
            StudentDao studentDao = new StudentDao();
            List<Student> studentList;
            studentList = studentDao.view();
            display.print("<div class=\"col-md-8 col-md-offset-2\" >");
            display.print("<table class=\"table center table-hover table-responsive table-bordered\">");
            display.print("<caption class=\"text-center\">Students</caption>");
//        display.print("<th class=\"text-center success\">Student ID</th>");
            display.print("<th class=\"text-center success\">Student Name</th>");
            display.print("<th class=\"text-center success\">Student Email</th>");
            display.print("<th class=\"text-center success\">Edit</th>");
            display.print("<th class=\"text-center success\">Delete</th>");
            display.print("<tr>");


            for (Student student : studentList) {

                if (student.getName() != null && student.getName().toLowerCase().contains(req.getParameter("search").toLowerCase())
                        || student.getName().equalsIgnoreCase(req.getParameter("search"))) {
                    display.print("<div class=\"row \">");
//                    display.print("<td>" + student.getStudentId() + "</td>");
                    display.print("<td>" + student.getName() + "</td>");
                    display.print("<td>" + student.getEmail() + "</td>");
                    display.print("<td><a><button id=\"\" class=\"btn btn-success btn-sm \">Edit</button></a></td>");
                    display.print("<td><a href=\"delete?id=" + student.getStudentId() + "\"><button id=\"\" class=\"btn btn-danger " +
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
