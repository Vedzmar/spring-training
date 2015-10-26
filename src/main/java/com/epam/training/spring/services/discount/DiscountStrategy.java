package com.epam.training.spring.services.discount;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;


public interface DiscountStrategy {

    float getDiscount(Showing showing, User user, boolean isVip);
}
