package com.company.dao.impl;

import com.company.confing.PostgresSQL;
import com.company.dao.UserDao;
import com.company.model.User;
import com.sun.research.ws.wadl.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl extends PostgresSQL implements UserDao {

    @Override
    public User save(User user) {
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement("insert into users(user_login, user_password)" +
                                                                            "values(?, ?)");
            ResultSet resultSet = statement.getGeneratedKeys()){
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            if(resultSet.next()){
                user.setId(resultSet.getLong(1));
            }
            return user;
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ":" + e.getMessage());

        }
        return null;
    }
}
