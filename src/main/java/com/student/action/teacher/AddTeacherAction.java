package com.student.action.teacher;

import com.student.dao.TeacherDao;
import com.student.dao.UserDao;
import com.student.models.Teacher;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(
        name = "AddTeacher",
        urlPatterns = "/teacher/add"
)
public class AddTeacherAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(teacher);

        TeacherDao teacherDao = new TeacherDao();

        if (teacherDao.add(teacher)) {
            UserDao userDao = new UserDao();
            if (userDao.add(teacher))
                resp.sendRedirect("../view-students.jsp");
            else
                System.out.println("something went wrong");
        }
        resp.sendRedirect("../add-teacher.jsp");


    }
}
