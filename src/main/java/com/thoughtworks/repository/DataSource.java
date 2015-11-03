package com.thoughtworks.repository;

import com.thoughtworks.business.object.Student;

public interface DataSource {

    void add(Student studentObj);

    Student getStudentByID(int i) throws Exception;
}
