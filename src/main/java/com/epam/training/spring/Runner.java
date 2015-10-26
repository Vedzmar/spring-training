package com.epam.training.spring;

import com.epam.training.spring.services.BookingService;
import com.epam.training.spring.services.TheatreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    
    public static void main(String args[]){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");

        System.out.println( ((BookingService)ctx.getBean("bookingService")).getAllTickets() );
    }
}
