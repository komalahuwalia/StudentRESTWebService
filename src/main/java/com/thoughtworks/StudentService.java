package com.thoughtworks;

import com.thoughtworks.business.object.Student;
import com.thoughtworks.repository.DataSource;
import com.thoughtworks.repository.InMemoryDataSource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
public class StudentService {


    private DataSource dataSource = null;

    public StudentService(){
        System.out.println("Constructed!!");
        dataSource = new InMemoryDataSource();
    }

    public StudentService(DataSource dataSource){
        this.dataSource = dataSource;
    }

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
        dataSource.add(student);
        return Response.ok("OK", MediaType.TEXT_HTML).build();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") String id){
        try {
            Student student = dataSource.getStudentByID(Integer.parseInt(id));
            return Response.ok(student, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok("Error", MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(Student student){
        dataSource.updateStudent(student);
        return Response.ok("OK", MediaType.TEXT_HTML).build();
    }

}
