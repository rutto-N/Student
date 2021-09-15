package com.student.action.course;

import com.student.dao.CourseDao;
import com.student.dao.StudentDao;
import com.student.models.Course;
import com.student.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        name="DeleteCourse",
        urlPatterns ="/course/delete"
)
public class DeleteCourseAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter display = resp.getWriter();
        Course course =new Course();

        course.setCourseId(Integer.parseInt(req.getParameter("id")));

        System.out.println(course);
        CourseDao courseDao =new CourseDao();
        if (courseDao.delete(course)) {
            display.print("Course was Deleted Successfully");
            resp.sendRedirect("./view");
        }
        else{
            display.print("Something went wrong");
        }

    }
}
