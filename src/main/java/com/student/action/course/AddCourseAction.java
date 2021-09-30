package com.student.action.course;

import com.student.dao.UnitDao;
import com.student.models.Unit;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(
        name = "AddCourse",
        urlPatterns = "/course/add"
)
public class AddCourseAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Unit unit = new Unit();
        System.out.println(req.getParameter("gradeId"));

        try {
            BeanUtils.populate(unit, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(unit);
        int userId = (int) session.getAttribute("id");
        System.out.println(userId);
        UnitDao unitDao = new UnitDao();
        if (unitDao.add(unit)) {
            resp.sendRedirect("../view-courses.jsp");
        }
        resp.sendRedirect("../add-course.jsp");


    }
}
