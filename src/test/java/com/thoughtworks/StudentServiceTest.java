package com.thoughtworks;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;


import static org.junit.Assert.*;


public class StudentServiceTest {

    @Test
    public void getHelloInHTML(){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student");
        String response = webResource.get(String.class);
        assertEquals("Saying Hi...", response);
    }

    @Test
    public void shouldBeAbleToAddStudent() throws Exception{

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/add");
        JSONObject studentObject = new JSONObject();
        JSONObject nameObject = new JSONObject();
        nameObject.put("fName","A");
        nameObject.put("lName","B");
        studentObject.put("id",1);
        studentObject.put("name",nameObject);
        webResource.post(studentObject);

        webResource = client.resource("http://localhost:8080/StudentRESTWebService/student/find/1");
        String response = webResource.get(String.class);
        assertEquals(studentObject.toString(), response);
    }

}