package com.thoughtworks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class StudentService {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHi(){
        return "Saying Hi...";
    }


}
