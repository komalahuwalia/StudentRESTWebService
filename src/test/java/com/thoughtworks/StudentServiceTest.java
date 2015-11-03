package com.thoughtworks;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

import static org.junit.Assert.*;


public class StudentServiceTest {

    @Test
    public void getHelloInHTML(){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student");
        String response = webResource.get(String.class);
        assertEquals("Saying Hi...",response);
    }

    @Test
    public void shouldBeAbleToAddStudent(){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/StudentRESTWebService/student");
        String response = webResource.get(String.class);
        assertEquals("Saying Hi...",response);
    }

}