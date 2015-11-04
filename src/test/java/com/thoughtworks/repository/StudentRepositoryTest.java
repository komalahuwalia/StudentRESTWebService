package com.thoughtworks.repository;

import com.thoughtworks.business.object.Name;
import com.thoughtworks.business.object.Student;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StudentRepositoryTest {

    private StudentRepository repositoryObj;
    private Student studentObj;

    @Before
    public void setUp() throws Exception {
        studentObj = new Student(1,new Name("a","b"));
        repositoryObj = new StudentRepository();
        repositoryObj.setDataSource(new InMemoryDataSource());
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldBeAbleToSearchStudentByID() throws Exception {
        repositoryObj.addStudent(studentObj);
        Student expectedStudentObj = repositoryObj.getStudentByID(1);
        assertTrue(studentObj.equals(expectedStudentObj));
    }

   @Test(expected = Exception.class)
    public void shouldBeAbleToThrowAnErrorWhileSearchingNonAddedStudent() throws Exception {
        repositoryObj.addStudent(studentObj);
        repositoryObj.getStudentByID(2);
        exception.expect(Exception.class);
        exception.expectMessage("object with given key is not present");
    }

    @Test
    public void shouldBeAbleToUpdateExistingStudentDetails() throws Exception{
        repositoryObj.addStudent(studentObj);
        Student fetchedStudentObj = repositoryObj.getStudentByID(1);

        fetchedStudentObj.setName(new Name("jkl","xyz"));
        repositoryObj.updateStudent(fetchedStudentObj);

        Student expectedStudentObj = repositoryObj.getStudentByID(1);
        assertTrue(fetchedStudentObj.equals(expectedStudentObj));

    }
}