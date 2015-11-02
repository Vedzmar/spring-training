package com.epam.training.spring.aspects;

import com.epam.training.spring.domains.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * count how many times each discount was given total 
 * and for specific user
 *  
 */
@Aspect
public class DiscountAspect implements DiscountCounter {
    
    private Map<Class, Integer> countsByStrategy = new HashMap<>();
    private Map<User, Integer> countsByUser = new HashMap<>();

    @Pointcut("execution(* *..DiscountStrategy.getDiscount(..))")
    private void gettingDiscountPointcut(){}
    
    @AfterReturning(
            pointcut = "gettingDiscountPointcut() && args(*, user, ..)",
            returning = "discount")
    private void discountGot(JoinPoint joinPoint, User user, float discount){
        if (discount < 1.0f) {
            initOrIncrement(countsByStrategy, joinPoint.getTarget().getClass());
            initOrIncrement(countsByUser, user);
        }
    }

    private <T> void initOrIncrement(Map<T, Integer> countsByStrategy, T key) {
        if (!countsByStrategy.containsKey(key)) {
            countsByStrategy.put(key, 0);
        }

        int count = countsByStrategy.get(key);
        countsByStrategy.put(key, count + 1);
    }

    @Override
    public int getDiscountCountByStrategy(Class clazz) {
        return countsByStrategy.containsKey(clazz) ? countsByStrategy.get(clazz) : 0;
    }

    @Override
    public int getDiscountsForUser(User user) {
        return countsByUser.containsKey(user) ? countsByUser.get(user) : 0;
    }
}
