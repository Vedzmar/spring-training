package com.epam.training.spring.services.discount;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;


/**
 *  10% discount if birthday in the same day with showing
 */
public class BirthdayDiscountStrategy implements DiscountStrategy {

    public static final float BIRTHDAY_DISCOUNT_FACTOR = .9f;

    @Override
    public float getDiscount(Showing showing, User user, boolean isVip) {

        MonthDay showingDate = new MonthDay(showing.getDate());

        MonthDay birthday = new MonthDay(user.getBirthday());

        if (birthday.isEqual(showingDate)){
            return BIRTHDAY_DISCOUNT_FACTOR;
        }

        return 1;
    }
}
