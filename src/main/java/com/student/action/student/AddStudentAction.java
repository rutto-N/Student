package com.student.action.student;

import com.student.dao.StudentDao;
import com.student.dao.UserDao;
import com.student.models.Student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddStudent", urlPatterns = "/student/add")


public class AddStudentAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = new Student();
        HttpSession session = req.getSession();

        try {
            BeanUtils.populate(student, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        student.setCreatedBy((Integer) session.getAttribute("id"));
        System.out.println(student);
//        int addedBy = (int) session.getAttribute("id");


        StudentDao studentDao = new StudentDao();

        if (studentDao.add(student)) {
            UserDao userDao = new UserDao();
            if (userDao.add(student))
                resp.sendRedirect("../view-students.jsp");
            else
                System.out.println("Student account couldn't be created");
            resp.sendRedirect("../add-student.jsp");

        }
        resp.sendRedirect("../add-student.jsp");


    }
}
