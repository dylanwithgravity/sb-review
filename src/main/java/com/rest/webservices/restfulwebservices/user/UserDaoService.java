package com.rest.webservices.restfulwebservices.user;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static  int userCounter = 3;

    static {
        users.add(new User(1, new Date(), "Adam"));
        users.add(new User(2, new Date(), "Eve"));
        users.add(new User(3, new Date(), "Dylan"));
    }

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        if(user.getId() == null) {
            user.setId(++userCounter);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user: users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}