package com.student.action.enrolments;

import com.student.dao.UnitDao;
import com.student.dao.EnrolmentDao;
import com.student.models.Enrolment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Enrol",
        urlPatterns = "/enrol/add"
)
public class EnrolAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UnitDao unitDao =new UnitDao();
        System.out.println("=======");
        System.out.println(unitDao.getCoursesByGrade((String) session.getAttribute("grade")));



        String[] courses = req.getParameterValues("courseId");
        for (String input : courses) {
            Enrolment enrolment = new Enrolment();
            enrolment.setCourseId(Integer.parseInt(input));
            enrolment.setStudentId((Integer) session.getAttribute("id"));
            System.out.println(enrolment);
            EnrolmentDao enrolmentDao = new EnrolmentDao();

//check if student is enrolled for the same course
            if (!enrolmentDao.checkEnrolled(enrolment)) {
                enrolmentDao.add(enrolment);
            }
            System.out.println("Already enrolled for ..Enrol for another one");

            System.out.println(input);

        }
        resp.sendRedirect("../view-enrolments.jsp");




    }
}
