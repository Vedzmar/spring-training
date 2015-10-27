package com.epam.training.spring;

import com.epam.training.spring.services.BookingService;
import com.epam.training.spring.services.DiscountService;
import com.epam.training.spring.services.discount.DiscountStrategy;
import com.epam.training.spring.services.impl.DiscountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");

        BookingService bookingService = (BookingService)ctx.getBean("bookingService");
        DiscountStrategy discountStrategy = (DiscountStrategy)ctx.getBean("eachTenTicketDiscountStrategy");
        System.out.println(discountStrategy);
        DiscountServiceImpl discountService = (DiscountServiceImpl)ctx.getBean("discountService");
        System.out.println(discountService.getDiscountStrategies());

    }
}
