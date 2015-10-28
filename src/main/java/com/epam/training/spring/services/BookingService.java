package com.epam.training.spring.services;


import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.Ticket;
import com.epam.training.spring.domains.User;

import java.util.List;

/**
 * BookingService - Manages tickets, prices, bookings

 - bookTicket( showing,  user,  isVip) can throw HasNoTicketException;
 - getAllTickets();
 - getTicketsByUser( user );
 - getAvailableTickets( showing );
 - getAvailableVipTickets( showing );
 - getTicketsByShowing( showing );
 - getVipTicketsByShowing( showing );
 - getById(id)

 */
public interface BookingService extends GenericService<Ticket> {
    
    Ticket bookTicket(Showing showing, User user, boolean isVip) throws HasNoTicketException;
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByUser(User user);
    long getAvailableTickets(Showing showing);
    long getAvailableVipTickets(Showing showing);
    
    List<Ticket> getTicketsByShowing(Showing showing);
    List<Ticket> getVipTicketsByShowing(Showing showing);
}
