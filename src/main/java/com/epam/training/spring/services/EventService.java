package com.epam.training.spring.services;


import com.epam.training.spring.domains.Event;

import java.util.Date;

public interface EventService {
    
    Event create(String name, Date date);
}
