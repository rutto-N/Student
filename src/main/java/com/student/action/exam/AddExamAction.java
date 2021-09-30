package com.student.action.exam;

import com.student.bean.MarksBean;
import com.student.dao.EnrolmentDao;
import com.student.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AddExam",urlPatterns = "/exam/add")
public class AddExamAction extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        System.out.println(req.getParameter("name")+"======"+session.getAttribute("course"));
        System.out.println(session.getAttribute("id")+"*******"+session.getAttribute("email"));
        EnrolmentDao enrolmentDao=new EnrolmentDao();
        List<Student> students=enrolmentDao.getEnrolledStudentsByCourse((Integer) session.getAttribute("course"));
        MarksBean marksBean=new MarksBean();
        marksBean.awardMarks(students, Integer.parseInt(req.getParameter("name")));
        System.out.println(students);


    }
}
