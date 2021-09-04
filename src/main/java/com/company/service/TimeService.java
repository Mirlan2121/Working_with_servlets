package com.company.service;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Path("/time")
public class TimeService {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response time(){
        Date time = new Date();
        return Response.ok().entity(
                new GregorianCalendar().get(Calendar.HOUR) + " : " +
                        new GregorianCalendar().get(Calendar.MINUTE)
        ).build();
    }

}
