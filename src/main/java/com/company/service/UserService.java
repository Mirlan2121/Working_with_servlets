package com.company.service;

import com.company.dao.impl.UserDataImpl;
import com.company.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
    public class UserService {
        UserDataImpl userDao = new UserDataImpl();

        @POST
        @Consumes({MediaType.APPLICATION_JSON})
        @Produces({MediaType.APPLICATION_JSON})
        public Response userSave(User user){

            user =userDao.save(user);

            if (user != null){
                try {
                    if(user.getDateBerth() > 2000){
                        return  Response.ok().entity(new Exception("Превышен год рождения")).build();
                    }
                }catch (Exception e){
                    System.out.println(e.getClass().getName() + ": " + e.getMessage());
                }
                return Response.ok().entity(user.toString()).build();
            }
            return Response.ok().entity("Некоректно введенны значения").build();
        }

        @GET
        @Produces({MediaType.APPLICATION_JSON})
        public Response getAll(){
            List<User> allUser = userDao.getAllUsers();
            return Response.ok().entity(allUser).build();
        }

        @POST
        @Path("/deleteUser")
        @Consumes({MediaType.APPLICATION_JSON})
        public Response deleteUser(User user){
            User man = user;
            userDao.delete(user);
            return Response.ok().entity(man + " Успешно удален").build();
        }

        @POST
        @Path("/{id}")
        @Consumes({MediaType.APPLICATION_JSON})
        @Produces({MediaType.APPLICATION_JSON})
        public Response getById(@PathParam("id") Long id){

            return Response.ok().entity(userDao.getById(id)).build();
        }
    }




