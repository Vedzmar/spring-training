package com.epam.training.spring.aspects;

import com.epam.training.spring.domains.Showing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.training.spring.aspects.DbHelper.createOrUpdateTable;
import static com.epam.training.spring.aspects.DbHelper.getCountByTableAndId;

/**
 *
 * count how many times each Showing was accessed by name,
 * how many times its tickets were booked.
 * Store counters in map for now (later could be replaced by DB dao)
 *
 */
@Aspect
public class CounterAspect implements ShowingCounter {

    @Inject
    private JdbcTemplate jdbcTemplate;

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
            createOrUpdateTable(jdbcTemplate, "counter_access", showing.getId());
        }
    }

    @Before("whenBookedTicket() && args(showing,..)")
    public void countBookedTicketsByShowingAdvice(Showing showing){
        createOrUpdateTable(jdbcTemplate, "counter_booked", showing.getId());
    }

    @Override
    public long getAccessCount(Showing showing) {
        return getCountByTableAndId(jdbcTemplate, "counter_access", showing.getId());
    }

    @Override
    public long getBookCount(Showing showing) {
        return getCountByTableAndId(jdbcTemplate, "counter_booked", showing.getId());
    }
}
