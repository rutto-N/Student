package com.student.action.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        name = "ViewUsers",
        urlPatterns = {"/users/view", "/users/"}
)
public class ViewUsers extends HttpServlet {


    public void destroy() {
        System.out.println("Killing servlet....");
    }


}
