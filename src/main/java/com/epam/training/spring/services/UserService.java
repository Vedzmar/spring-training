package com.epam.training.spring.services;

import com.epam.training.spring.domains.User;

import java.util.Date;


public interface UserService extends GenericService<User> {
    
    public User register(String name, String email, Date birthday);
    
    public User remove(User user);
    
    public User getUserByEmail(String email);
    
    public User getUsersByName(String name);
}
