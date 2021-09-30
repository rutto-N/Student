package com.student.action.user;

import com.student.dao.StudentDao;
import com.student.dao.TeacherDao;
import com.student.dao.UserDao;
import com.student.interfaces.StudentI;
import com.student.interfaces.TeacherI;
import com.student.interfaces.UserI;
import com.student.models.Student;
import com.student.models.Teacher;
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

@WebServlet(name = "Login", urlPatterns = "/login")


public class SignInAction extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);


        if (!req.getParameter("email").isEmpty() && !req.getParameter("password").isEmpty()) {
            User user = new User();

            try {
                BeanUtils.populate(user, req.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserI userDao = new UserDao();
            user = userDao.getUser(user);
            if (user != null) {
                switch (user.getRoleId()){
                    case 1:
                        session.setAttribute("id", user.getId());
                        session.setAttribute("email", user.getEmail());
                    break;
                    case 2:
                        StudentI studentDao=new StudentDao();
                        Student student=studentDao.getStudent(user.getEmail());
                        session.setAttribute("id", student.getStudentId());
                        session.setAttribute("email", student.getEmail());
                        session.setAttribute("grade", student.getGrade());
                        session.setAttribute("course", student.getCourse());

                        System.out.println(session.getAttribute("course"));

                        System.out.println(student);
                        break;
                    case 3:
                        TeacherI teacherDao=new TeacherDao();
                        Teacher teacher=teacherDao.getTeacher(user.getEmail());
                        session.setAttribute("id", teacher.getTeacherId());
                        session.setAttribute("email", teacher.getEmail());
                        session.setAttribute("course", teacher.getCourseId());
                        System.out.println(teacher);
                        break;
                }



                resp.sendRedirect("./view-courses.jsp");
                System.out.println(session.getAttribute("id"));
            } else
                resp.sendRedirect("./login.jsp");
        } else {
            resp.sendRedirect("./login.jsp");
        }

    }
}
