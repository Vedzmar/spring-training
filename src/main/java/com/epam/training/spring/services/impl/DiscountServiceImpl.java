package com.epam.training.spring.services.impl;


import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.User;
import com.epam.training.spring.services.DiscountService;
import com.epam.training.spring.services.discount.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    @Resource
    public List<DiscountStrategy> discountStrategies;


    /**
     * @param showing
     * @param user
     * @param isVip
     * @return max discount value from all possible discounts
     */
    @Override
    public float getDiscount(Showing showing, User user, boolean isVip) {
        float discount = 1;
        
        for (DiscountStrategy strategy : discountStrategies){
            float discountFromStrategy = strategy.getDiscount(showing, user, isVip);
            
            if (discountFromStrategy < discount){
                discount = discountFromStrategy;
            }
        }
        
        return discount;
    }

}
