package com.company.service;

import com.company.dao.impl.UserDaoImpl;
import com.company.model.User;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response save(User user){
        user = new UserDaoImpl().save(user);
        String out;
        if (user != null){
            out = "Данные успешно вынесыны" + user;
        }else out = "Ошибка вынесение";
        return Response.ok().entity(out).build();
    }
}
