package com.epam.training.spring.services.discount;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;
import com.epam.training.spring.services.BookingService;

import javax.inject.Inject;

public class EachTenTicketDiscountStrategy implements DiscountStrategy {

    @Inject
    private BookingService bookingService;
    
    @Override
    public float getDiscount(Showing showing, User user, boolean isVip) {
        return 0;
    }
}
