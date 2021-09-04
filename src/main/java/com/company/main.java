package com.company;

import com.company.dao.UserDao;
import com.company.dao.impl.UserDaoImpl;
import com.company.model.User;

public class main {
    public static void main(String[] args) {
        User man = new User();
        man.setLogin("MIKI");
        man.setPassword("qwerty");
        UserDao userDao = new UserDaoImpl();
        man = userDao.save(man);
        System.out.println(man);
    }
}
