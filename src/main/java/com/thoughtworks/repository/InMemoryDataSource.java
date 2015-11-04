package com.thoughtworks.repository;

import com.thoughtworks.business.object.Student;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDataSource implements DataSource {

    private static Map<Integer,Student> students = new HashMap<Integer,Student>();;

    @Override
    public void add(Student studentObj) {
        students.put(studentObj.getId(), studentObj);
    }

    @Override
    public Student getStudentByID(int i) {
        System.out.println(" Count: "+students.size());
        return students.get(i);
    }

}
