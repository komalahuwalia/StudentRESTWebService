package com.thoughtworks;

import com.thoughtworks.business.object.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
public class StudentService {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHi(){
        return "Saying Hi...";
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student){
        System.out.println("student is:"+student);
        return Response.ok("OK", MediaType.TEXT_HTML).build();
    }


}
