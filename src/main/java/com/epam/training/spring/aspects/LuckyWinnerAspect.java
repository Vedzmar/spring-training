package com.epam.training.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 *
 * every time the bookTicket method is executed perform the checkLucky method for the user that based on some randomness
 * will return true or false. 
 * If user is lucky, the ticketPrice changes to zero and ticket is booked,thus user pays nothing. 
 *
 */
@Aspect
public class LuckyWinnerAspect {

    public static final double LUCKY_CHANCE_PERCENT = .1; //every 1000th

    @Pointcut("execution(* *..DiscountService.getDiscount(..))")
    private void whenGettingDiscount(){}

    @Around("whenGettingDiscount()")
    private Object aroundGettingDiscount(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(Arrays.asList( joinPoint.getArgs() )  );
        
        if (isLucky()){
            return 0f;
        }else {
            return joinPoint.proceed( joinPoint.getArgs() );
        }
    }

    private boolean isLucky() {
        return Math.random() < (LUCKY_CHANCE_PERCENT / 100);
    }

}
