package com.epam.training.spring.aspects;

import com.epam.training.spring.domains.Showing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * count how many times each Showing was accessed by name,
 * how many times its tickets were booked.
 * Store counters in map for now (later could be replaced by DB dao)
 *
 */
@Aspect
public class CounterAspect implements ShowingCounter {

    private Map<Showing, Integer> showingAccessing = new HashMap<>();

    private Map<Showing, Integer> showingTicketBooking = new HashMap<>();

    @Pointcut("execution(* *..ShowingService.getShowingsByMovie(..))")
    private void whenAskShowingByMovie(){}

    @Pointcut("execution(* *..BookingService.bookTicket(..))")
    private void whenBookedTicket(){}

    @AfterReturning(
            pointcut = "whenAskShowingByMovie()",
            returning = "showings"
    )
    public void countAccessShowingAdvice(List<Showing> showings){
        for (Showing showing : showings){
            initOrIncrement(showingAccessing, showing);
        }
    }

    @Before("whenBookedTicket() && args(showing,..)")
    public void countBookedTicketsByShowingAdvice(Showing showing){
        initOrIncrement(showingTicketBooking, showing);
    }

    private void initOrIncrement(Map<Showing, Integer> map, Showing showing) {
        if (!map.containsKey(showing)){
            map.put(showing, 0);
        }

        int count = map.get(showing);
        map.put(showing, count + 1);
    }

    @Override
    public int getAccessCount(Showing showing) {
        if (!showingAccessing.containsKey(showing)) return 0;

        return showingAccessing.get(showing);
    }

    @Override
    public int getBookCount(Showing showing) {
        if (!showingTicketBooking.containsKey(showing)) return 0;

        return showingTicketBooking.get(showing);
    }
}
