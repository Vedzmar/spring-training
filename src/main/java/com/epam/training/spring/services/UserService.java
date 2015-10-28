package com.epam.training.spring.services;

import com.epam.training.spring.domains.User;

import java.util.Date;
import java.util.List;


/**
 * Manages registered users

 - register
 - remove
 - getById
 - getUserByEmail
 - getUsersByName

 */
public interface UserService extends GenericService<User> {
    
    public User register(String name, String email, Date birthday) throws RegistrationException;
    
    public void remove(User user);
    
    public User getUserByEmail(String email);
    
    public List<User> getUsersByName(String name);
}
