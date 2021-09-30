package com.student.interfaces;

import com.student.models.Enrolment;
import com.student.models.EnrolmentDetail;
import com.student.models.Student;

import java.util.List;

public interface EnrolmentI extends CrudI<Enrolment> {
    List<EnrolmentDetail> viewEnrolments();

    List<EnrolmentDetail> viewEnrolmentsPerStudent(int studentId);

    @Override
    boolean delete(Enrolment enrolment);

    boolean checkEnrolled(Enrolment enrolment);

    List<Student> getEnrolledStudentsByCourse(int courseId);
}
