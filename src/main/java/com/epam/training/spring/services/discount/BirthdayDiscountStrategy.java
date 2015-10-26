package com.epam.training.spring.services.discount;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;


public class BirthdayDiscountStrategy implements DiscountStrategy {


    @Override
    public float getDiscount(Showing showing, User user, boolean isVip) {



        return 1;
    }
}
