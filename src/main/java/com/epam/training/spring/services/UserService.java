package com.epam.training.spring.services;

import com.epam.training.spring.domains.Ticket;
import com.epam.training.spring.domains.User;


public interface UserService {
    
    public User register(User user);
    
    public User remove(User user);
    
    public User getById(long id);
    
    public User getUserByEmail(String email);
    
    public User getUsersByName(String name);
    
    public User getUserByTicket(Ticket ticket);
}
