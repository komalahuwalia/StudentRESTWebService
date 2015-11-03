package com.thoughtworks.repository;

import com.thoughtworks.business.object.Name;
import com.thoughtworks.business.object.Student;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StudentRepositoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldBeAbleToSearchStudentByID() throws Exception {
        Student studentObj = new Student(1,new Name("a","b"));
        StudentRepository repositoryObj = new StudentRepository();
        repositoryObj.setDataSource(new InMemoryDataSource());
        repositoryObj.addStudent(studentObj);
        Student expectedStudentObj = repositoryObj.getStudentByID(1);
        assertTrue(studentObj.equals(expectedStudentObj));
    }

   @Test(expected = Exception.class)
    public void shouldBeAbleToThrowAnErrorWhileSearchingNonAddedStudent() throws Exception {
        Student studentObj = new Student(1,new Name("a","b"));
        StudentRepository repositoryObj = new StudentRepository();
        repositoryObj.setDataSource(new InMemoryDataSource());
        repositoryObj.addStudent(studentObj);
        repositoryObj.getStudentByID(2);
        exception.expect(Exception.class);
        exception.expectMessage("object with given key is not present");
    }
}