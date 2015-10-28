package com.epam.training.spring.services.discount;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;
import com.epam.training.spring.services.BookingService;

import javax.inject.Inject;

/**
 * 50% discount for every tenth ticket
 */
public class EachTenthTicketDiscountStrategy implements DiscountStrategy {

    public static final float DEFAULT_EVERY_TEN_DISCOUNT_FACTOR = .5f;

    @Inject
    private BookingService bookingService;
    
    @Override
    public float getDiscount(Showing showing, User user, boolean isVip) {
        long ticketsCount = bookingService.getTicketsByUser(user).size();

        if (ticketsCount % 10 == 9){
            return DEFAULT_EVERY_TEN_DISCOUNT_FACTOR;
        }

        return 1;
    }
}
