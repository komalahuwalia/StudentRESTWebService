package com.thoughtworks.repository;

import com.thoughtworks.business.object.Student;

public class StudentRepository {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addStudent(Student studentObj) {
        dataSource.add(studentObj);
    }

    public Student getStudentByID(int i) throws Exception {
        Student studentObj = dataSource.getStudentByID(i);
        if (studentObj == null)
            throw new Exception("object with given key is not present");
        else
            return studentObj;
    }
}
