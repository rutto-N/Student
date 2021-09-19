package com.student.action.course;

import com.student.dao.CourseDao;
import com.student.models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name="ViewCourses",
        urlPatterns ={"/course/view","/course/"}
)

public class ViewCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        List<Course> courseList=new CourseDao().view();
        req.setAttribute("courses",courseList);

    }
    public void destroy() {
        System.out.println("Killing servlet....");

    }




}
