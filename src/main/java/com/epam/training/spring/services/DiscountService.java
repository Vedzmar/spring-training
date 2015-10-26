package com.epam.training.spring.services;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;

public interface DiscountService {
    
    float getDiscount(Showing showing, User user, boolean isVip);
}
