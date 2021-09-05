package com.company.dao.impl;

import com.company.confing.PostgresSQL;
import com.company.dao.UserDao;
import com.company.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDataImpl extends PostgresSQL implements UserDao {
    @Override
    public User save(User user) {
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.users\n" +
                    "(login, dateberth, gender)\n" +
                    "VALUES(?, ?, ?);\n");
            ResultSet set = statement.getGeneratedKeys()){
            statement.setString(1, user.getLogin());
            statement.setInt(2, user.getDateBerth());
            statement.setBoolean(3,user.getGender());
            statement.executeUpdate();
            if(set.next()){
                user.setId(set.getLong(1));
            }
            return user;

        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users;");
            ResultSet set = statement.executeQuery()) {
            List<User> users = new ArrayList<>();
            while (set.next()){
                User user = new User();
                user.setId(set.getLong("id_user"));
                user.setLogin(set.getString("login"));
                user.setDateBerth(set.getInt("dateBerth"));
                user.setGender(set.getBoolean("gender"));
                users.add(user);
            }

            return users;
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public User delete(User user) {
        String write = "delete from users where login = '" + user.getLogin() + "';";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(write)){

            statement.executeUpdate();
            return user;

        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public User getById(Long id) {
        String write = "select * from users where id_user = " + id + ";";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(write);
             ResultSet set= statement.executeQuery()){
            if(set.next()){
                User user = new User(set.getLong("id_user"),
                        set.getString("login"),
                        set.getInt("dateBerth"),
                        set.getBoolean("gender"));
                return user;
            }
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    @Override
    public User getByLogin(String login) {
        String write = "select * from users where login = '" + login + "';";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(write);
             ResultSet set= statement.executeQuery()){
            if(set.next()){
                User user = new User(set.getLong("id_user"),
                        set.getString("login"),
                        set.getInt("dateBerth"),
                        set.getBoolean("gender"));
                return user;
            }
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    @Override
    public List<User> getByDataBerth(int dataBerth) {
        String write = "select * from users where dateBerth = '" + dataBerth + "';";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(write);
             ResultSet set= statement.executeQuery()){
            List<User> users = new ArrayList<>();
            while(set.next()){
                User user = new User(set.getLong("id_user"),
                        set.getString("login"),
                        set.getInt("dateBerth"),
                        set.getBoolean("gender"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    @Override
    public List<User> getByGender(Boolean gender) {
        String write = "select * from users where gender = '" + gender + "';";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(write);
             ResultSet set= statement.executeQuery()){
            List<User> users = new ArrayList<>();
            while(set.next()){
                User user = new User(set.getLong("id_user"),
                        set.getString("login"),
                        set.getInt("dateBerth"),
                        set.getBoolean("gender"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

}
