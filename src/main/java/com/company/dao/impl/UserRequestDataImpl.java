package com.company.dao.impl;

import com.company.confing.PostgresSQL;
import com.company.dao.UserRequestDao;
import com.company.model.User;
import com.company.model.UserRequset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRequestDataImpl extends PostgresSQL implements UserRequestDao {

    @Override
    public UserRequset setNewRequset(User user) {
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user_request(request_data_time, id_user) +" +
                                                                       "Values(now(), ?);");
            ResultSet set = statement.getGeneratedKeys()){
            statement.setLong(1,user.getId());
            statement.executeUpdate();
            if (set.next()){
                return new UserRequset(set.getLong("id"),
                        set.getTime("request_data_time"),
                        user);
            }

        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<UserRequset> getAllRequest() {
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT req.id_request, req.request_data_time, u.id_user, u.login, u.dateberth, u.gender\n" +
                            "FROM public.user_request req\n" +
                            "join users u on u.id_user = req.id_user;");
            ResultSet set = statement.executeQuery()){
            List<UserRequset> allRequest = new ArrayList<>();
            while(set.next()){
                UserRequset request = new UserRequset();
                request.setId(set.getLong("id_request"));
                request.setTimeLogs(set.getTime("request_data_time"));
                request.setUserRequest(new User(set.getLong("id_user"),
                        set.getString("login"),
                        set.getInt("dateberth"),
                        set.getBoolean("gender")));
                allRequest.add(request);
            }

            return allRequest;

        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deletAllRequest() {

    }
}
