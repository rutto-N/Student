package com.student.action.student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet (
        name="ViewStudents",
        urlPatterns ={"/student/view","/student/"}
)

public class ViewStudents extends HttpServlet {


    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        PrintWriter display= resp.getWriter();
//        display.println(HTML_START+""+NAVBAR);
//        resp.sendRedirect("../view-students.jsp");
//
//
//    }
    public void destroy() {
        System.out.println("Killing servlet....");
    }


}



