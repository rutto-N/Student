package com.student.action.course;

import com.student.dao.UnitDao;
import com.student.models.Unit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        name = "DeleteCourse",
        urlPatterns = "/course/delete"
)
public class DeleteCourseAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        Unit unit = new Unit();

        unit.setCourseId(Integer.parseInt(req.getParameter("id")));

        System.out.println(unit);
        UnitDao unitDao = new UnitDao();
        if (unitDao.delete(unit)) {
            display.print("Course was Deleted Successfully");
            resp.sendRedirect("../view-courses.jsp");
        } else {
            display.print("Something went wrong");
        }

    }
}
