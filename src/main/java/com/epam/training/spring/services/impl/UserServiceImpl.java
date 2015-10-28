package com.epam.training.spring.services.impl;

import com.epam.training.spring.domains.User;
import com.epam.training.spring.services.RegistrationException;
import com.epam.training.spring.services.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * implementation of UserService
 */
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public User register(String name, String email, Date birthday) throws RegistrationException {
        if (isUserWithEmailExists(email))
            throw new RegistrationException("User with this email already exists");

        User user = new User(name, email, birthday);

        users.add(user);

        return user;
    }

    @Override
    public void remove(User user) {
        Iterator<User> i = users.iterator();

        while (i.hasNext()){
            if (i.next().getId() == user.getId()) {
                i.remove();
            }
        }
    }


    @Override
    public User getUserByEmail(String email) {
        for(User user : users){
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        List<User> usersByName = new ArrayList<>();

        for(User user : users){
            if (user.getName().equals(name)){
                usersByName.add(user);
            }
        }

        return usersByName;
    }

    @Override
    public User getById(long id) {
        for(User user : users){
            if ( user.getId() == id ) {
                return user;
            }
        }
        return null;
    }

    private boolean isUserWithEmailExists(String email) {
        return getUserByEmail(email) != null;
    }
}
