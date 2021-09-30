package com.student.interfaces;

import com.student.models.Student;
import com.student.models.Teacher;
import com.student.models.User;

public interface UserI extends CrudI<User> {
    boolean add(Student student);

    boolean add(Teacher teacher);

    User getUser(User user);
}
