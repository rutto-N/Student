package com.student.action.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name="ViewUsers",
        urlPatterns ={"/users/view","/users/"}
)
public class ViewUsers extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        PrintWriter display= resp.getWriter();
//        display.println(HTML_START+""+NAVBAR);
//        resp.sendRedirect("../view-users.jsp");
//
//    }
    public void destroy() {
        System.out.println("Killing servlet....");
    }



}
