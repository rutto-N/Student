package com.student.action.auth;

import com.student.dao.StudentDao;
import com.student.dao.UserDao;
import com.student.models.Student;
import com.student.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="DeleteUser",
        urlPatterns ="/user/delete"
)
public class DeleteUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        User user =new User();

        user.setId(Integer.parseInt(req.getParameter("id")));

        System.out.println(user);
        UserDao userDao =new UserDao();
        if (userDao.delete(user)) {
            display.print("User was Deleted Successfully");
            resp.sendRedirect("./view");
        }
        else{
            display.print("Something went wrong");
        }

    }
}
