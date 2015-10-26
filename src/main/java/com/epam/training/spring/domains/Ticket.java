package com.epam.training.spring.domains;

public class Ticket extends GenericEntity {

    private Showing showing;
    private User user;
    private boolean isVip;
    private float price;

    public Ticket(Showing showing, User user, boolean isVip, float price) {
        super( System.currentTimeMillis() );
        this.showing = showing;
        this.user = user;
        this.isVip = isVip;
        this.price = price;
    }

    public Showing getShowing() {
        return showing;
    }

    public User getUser() {
        return user;
    }

    public boolean isVip() {
        return isVip;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "showing=" + showing.getMovie().getName() +
                ", user=" + user +
                ", isVip=" + isVip +
                ", price=" + price +
                '}';
    }
}
