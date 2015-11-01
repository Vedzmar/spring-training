package com.epam.training.spring;

import com.epam.training.spring.aspects.ShowingCounter;
import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.services.*;
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
        MovieService movieService = (MovieService)ctx.getBean("movieService");
        TheatreService theatreService = (TheatreService)ctx.getBean("theatreService");
        ShowingService showingService = (ShowingService)ctx.getBean("showingService");
        BookingService bookingService = (BookingService)ctx.getBean("bookingService");

        System.out.println( userService.getUserByEmail("dzianis_sudas@epam.com") );

        System.out.println(movieService.getMoviesByName("The Martian"));

        /*print showing by Movie*/

        List<Showing> theMartianShowings = showingService.getShowingsByMovie((Movie) ctx.getBean("TheMartianMovie"));
        System.out.println( theMartianShowings );

        /*print price of first ticket of user with email*/
        /*will be with 10% birthday discount*/
        System.out.println( bookingService.getTicketsByUser(userService.getUserByEmail("dzianis_sudas@epam.com")).get(0).getPrice() );

        //second time access to showing by Movie
        showingService.getShowingsByMovie((Movie) ctx.getBean("TheMartianMovie"));


        ShowingCounter showingCounter = (ShowingCounter)ctx.getBean("counterAspect");

        //print showing access count
        System.out.println( showingCounter.getAccessCount( theMartianShowings.get(0) ) );

        //print booking count
        System.out.println( showingCounter.getBookCount( theMartianShowings.get(0) ) );
    }
}
