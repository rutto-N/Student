package com.student.action.enrolments;

import com.student.dao.EnrolmentDao;
import com.student.models.Enrolment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "DeleteEnrolment",
        urlPatterns = "/enrolment/delete"
)
public class DeleteEnrolmentAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        Enrolment enrolment = new Enrolment();

        enrolment.setEnrolmentId(Integer.parseInt(req.getParameter("id")));

        System.out.println(enrolment);
        EnrolmentDao enrolmentDao = new EnrolmentDao();
        if (enrolmentDao.delete(enrolment)) {
            System.out.println(enrolmentDao.delete(enrolment));
            display.print("Enrolment was Deleted Successfully");
            resp.sendRedirect("../view-enrolments.jsp");
        } else {
            display.print("Something went wrong");
        }

    }
}
