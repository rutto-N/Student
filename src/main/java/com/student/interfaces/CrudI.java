package com.student.interfaces;

import java.util.List;

public interface CrudI<T> {
    boolean add(T t);

    List<T> view();

    boolean delete(T t);


}
