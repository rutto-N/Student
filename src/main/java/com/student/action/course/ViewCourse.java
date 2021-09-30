package com.student.action.course;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name = "ViewCourses",
        urlPatterns = {"/course/view", "/course/"}
)

public class ViewCourse extends HttpServlet {


    public void destroy() {
        System.out.println("Killing servlet....");

    }


}
