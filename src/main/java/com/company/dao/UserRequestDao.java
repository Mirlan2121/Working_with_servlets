package com.company.dao;

import com.company.model.User;
import com.company.model.UserRequset;

import java.util.List;

public interface UserRequestDao {

    UserRequset setNewRequset(User user);
    List<UserRequset> getAllRequest();
    void deletAllRequest();
}
