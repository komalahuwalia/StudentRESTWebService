package com.thoughtworks;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.thoughtworks.business.object.Name;
import com.thoughtworks.business.object.Student;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;


import static org.junit.Assert.*;


public class StudentServiceTest {

    @Test
    public void getHelloInHTML() {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student");
        String response = webResource.get(String.class);
        assertEquals("Saying Hi...", response);
    }

    @Test
    public void shouldBeAbleToAddStudent() throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/add");
        JSONObject studentObject = getJsonObject(new Student(1,new Name("a","b")));
        webResource.post(studentObject);

        webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/find/1");
        String response = webResource.get(String.class);
        assertEquals(studentObject.toString(), response);
    }

    @Test
    public void shouldBeAbleToUpdateExistingStudentDetails() throws Exception {

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/add");
        JSONObject studentObject = getJsonObject(new Student(1,new Name("a","b")));
        webResource.post(studentObject);

        webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/find/1");
        Student student = webResource.get(Student.class);
        student.setName(new Name("jkl","xyz"));

        webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/update");
        webResource.put(getJsonObject(student));

        webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/find/1");
        Student expectedStudent = webResource.get(Student.class);
        System.out.println(student);
        System.out.println(expectedStudent);
        assertEquals(expectedStudent,student);
    }

    private JSONObject getJsonObject(Student student) throws JSONException {
        JSONObject studentObject = new JSONObject();
        JSONObject nameObject = new JSONObject();
        nameObject.put("fName", student.getName().getfName());
        nameObject.put("lName", student.getName().getlName());
        studentObject.put("id", student.getId());
        studentObject.put("name", nameObject);
        return studentObject;
    }
}
