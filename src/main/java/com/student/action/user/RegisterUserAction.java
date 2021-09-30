package com.student.action.user;

import com.student.dao.UserDao;
import com.student.interfaces.UserI;
import com.student.models.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet(name = "Register", urlPatterns = "/register")

public class RegisterUserAction extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("password").trim().equals
                (req.getParameter("re-password").trim())) {//confirm passwords match
            User user = new User();
            try {
                BeanUtils.populate(user, req.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserI userDao = new UserDao();
            if (userDao.add(user)) {
                System.out.println("Added successfully");
                resp.sendRedirect("./login.jsp");
            } else
                resp.sendRedirect("./add-user.jsp");

        }


    }
}


