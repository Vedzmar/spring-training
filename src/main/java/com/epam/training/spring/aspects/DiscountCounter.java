package com.epam.training.spring.aspects;

import com.epam.training.spring.domains.User;


public interface DiscountCounter {
    int getDiscountCountByStrategy(Class clazz);
    int getDiscountsForUser(User user);
}
