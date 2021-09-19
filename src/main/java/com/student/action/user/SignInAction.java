package com.student.action.user;

import com.student.dao.UserDao;
import com.student.models.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name="Login",urlPatterns ="/login" )


public class SignInAction extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession(true);


        if (!req.getParameter("email").isEmpty() && !req.getParameter("password").isEmpty()){
            User user=new User();

            try {
                BeanUtils.populate(user,req.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
          UserDao userDao=new UserDao();
            user=userDao.getUser(user);
            if (user!=null){
                session.setAttribute("id",user.getId());

                session.setAttribute("email",user.getEmail());
                resp.sendRedirect("./view-courses.jsp");

            }else
                resp.sendRedirect("./login.jsp");


        }else {
            resp.sendRedirect("./login.jsp");
        }


    }
}
