package com.epam.training.spring;

import com.epam.training.spring.aspects.DiscountCounter;
import com.epam.training.spring.aspects.ShowingCounter;
import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.services.*;
import com.epam.training.spring.services.discount.BirthdayDiscountStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Runner {

    /**
        all data comes from dataPopulation.xml configuration
     */
    public static void main(String args[]) throws RegistrationException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml", "dataPopulation.xml");

        UserService userService = (UserService)ctx.getBean("userService");
        ShowingService showingService = (ShowingService)ctx.getBean("showingService");
        BookingService bookingService = (BookingService)ctx.getBean("bookingService");


        /*print showing by Movie*/

        List<Showing> theMartianShowings = showingService.getShowingsByMovie((Movie) ctx.getBean("TheMartianMovie"));

        //second time access to showing by Movie
        showingService.getShowingsByMovie((Movie) ctx.getBean("TheMartianMovie"));


        ShowingCounter showingCounter = (ShowingCounter)ctx.getBean("counterAspect");
        DiscountCounter discountCounter = (DiscountCounter)ctx.getBean("discountAspect");

        //print showing access count
        System.out.println( showingCounter.getAccessCount( theMartianShowings.get(0) ) );

        //print booking count
        System.out.println( showingCounter.getBookCount( theMartianShowings.get(0) ) );
        
        //print count by Discount
        System.out.println(discountCounter.getDiscountCountByStrategy(BirthdayDiscountStrategy.class));

        //print count by User
        System.out.println(
                discountCounter.getDiscountsForUser(
                    userService.getUserByEmail("dzianis_sudas@epam.com")
                )
        );

        System.out.println(
            bookingService.getTicketsByUser(
                    userService.getUserByEmail("dzianis_sudas@epam.com")
            ).get(0).getPrice() + "$"
        );
    }
}
