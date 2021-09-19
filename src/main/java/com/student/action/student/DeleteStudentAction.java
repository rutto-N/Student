package com.student.action.student;

import com.student.dao.StudentDao;
import com.student.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(
        name="DeleteStudent",
        urlPatterns ="/student/delete"
)
public class DeleteStudentAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        Student student =new Student();

        student.setStudentId(Integer.parseInt(req.getParameter("id")));

        System.out.println(student);
        StudentDao studentDao =new StudentDao();
        if (studentDao.delete(student)) {
            display.print("Student was Deleted Successfully");
            resp.sendRedirect("./view-student.jsp");
        }
        else{
            display.print("Something went wrong");
        }

    }
}
