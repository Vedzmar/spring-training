package com.epam.training.spring.services.discount;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;
import org.joda.time.LocalDate;


public class BirthdayDiscountStrategy implements DiscountStrategy {

    public static final float BIRTHDAY_DISCOUNT_FACTOR = 0.9f;

    @Override
    public float getDiscount(Showing showing, User user, boolean isVip) {

        LocalDate today = new LocalDate();

        LocalDate birthday = new LocalDate(user.getBirthday());

        if (birthday.isEqual(today)){
            return BIRTHDAY_DISCOUNT_FACTOR;
        }

        return 1;
    }
}
