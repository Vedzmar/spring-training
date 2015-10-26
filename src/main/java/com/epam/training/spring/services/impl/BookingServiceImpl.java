package com.epam.training.spring.services.impl;

import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.Ticket;
import com.epam.training.spring.domains.User;
import com.epam.training.spring.services.BookingService;
import com.epam.training.spring.services.DiscountService;
import com.epam.training.spring.services.HasNoTicketException;

import java.util.ArrayList;
import java.util.List;


public class BookingServiceImpl implements BookingService {

    public static final float DEFAULT_VIP_FACTOR = 1.1f;
    private final DiscountService discountService;

    private final List<Ticket> tickets = new ArrayList<Ticket>();
    
    public BookingServiceImpl(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public Ticket bookTicket(Showing showing, User user, boolean isVip) throws HasNoTicketException {
        if (hasNoTickets(showing, isVip)) 
            throw new HasNoTicketException("There is no ticket for particular criteria");
        
        
        float discount  = discountService.getDiscount(showing, user, isVip);
        float basePrice = showing.getMovie().getBasePrice();
        float vipFactor = DEFAULT_VIP_FACTOR;
        
        Ticket ticket;
        if (isVip) {
            ticket = new Ticket(showing, user, isVip, basePrice * vipFactor * discount);
        } else {
            ticket = new Ticket(showing, user, isVip, basePrice * discount);
        }
        
        tickets.add(ticket);
        
        return ticket;
    }

    private boolean hasNoTickets(Showing showing, boolean isVip) {
        return !hasTickets(showing, isVip);
    }

    private boolean hasTickets(Showing showing, boolean isVip) {
        if (isVip) {
            return getAvailableVipTickets(showing) != 0;
        } else {
            return getAvailableTickets(showing) != 0;
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByUser(User user) {
        List<Ticket> userTickets = new ArrayList<Ticket>();
        
        for (Ticket ticket : tickets){
            if (ticket.getUser() == user) userTickets.add(ticket);
            
        }
        
        return userTickets;
    }

    @Override
    public long getAvailableTickets(Showing showing) {
        
        return showing.getTheatre().getSeatsCount() - getTicketsByShowing(showing).size();
    }

    @Override
    public long getAvailableVipTickets(Showing showing) {
        return showing.getTheatre().getVipSeatsCount() - getVipTicketsByShowing(showing).size();
    }
    
    @Override
    public List<Ticket> getVipTicketsByShowing(Showing showing) {
        List<Ticket> vipTicketsByShowing = new ArrayList<Ticket>();

        for (Ticket ticket : tickets){
            if (ticket.getShowing() == showing && ticket.isVip()) vipTicketsByShowing.add(ticket);

        }

        return vipTicketsByShowing;
    }

    @Override
    public List<Ticket> getTicketsByShowing(Showing showing) {
        List<Ticket> ticketsByShowing = new ArrayList<Ticket>();

        for (Ticket ticket : tickets){
            if (ticket.getShowing() == showing) ticketsByShowing.add(ticket);

        }

        return ticketsByShowing;
    }

    @Override
    public Ticket getById(long id) {

        for (Ticket ticket : tickets){
            if (ticket.getId() == id) return ticket;
        }
        
        return null;
    }
}
