package com.student.action.user;

import com.student.dao.UserDao;
import com.student.interfaces.UserI;
import com.student.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "DeleteUser",
        urlPatterns = "/users/delete"
)
public class DeleteUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        User user = new User();

        user.setId(Integer.parseInt(req.getParameter("id")));

        System.out.println(user);
        UserI userDao = new UserDao();
        if (userDao.delete(user)) {
            display.print("User was Deleted Successfully");
            resp.sendRedirect("../view-users.jsp");
        } else {
            display.print("Something went wrong");
        }

    }
}
