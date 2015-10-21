package com.epam.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dzianis_Sudas on 10/21/2015.
 */
public class Runner {
    
    public static void main(String args[]){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        
        System.out.println( ctx.getBean("user") );
    }
}
