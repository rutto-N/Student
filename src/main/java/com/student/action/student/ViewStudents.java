package com.student.action.student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name = "ViewStudents",
        urlPatterns = {"/student/view", "/student/"}
)

public class ViewStudents extends HttpServlet {


    public void destroy() {
        System.out.println("Killing servlet....");
    }


}



