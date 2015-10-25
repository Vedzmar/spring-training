package com.epam.training.spring.domains;


public class Movie extends GenericEntity {

    private String name;
    private long duration;
    private float basePrice;
    private Rating rating;

    public Movie(String name, long duration, float basePrice, Rating rating) {
        super( System.currentTimeMillis() );
        this.name = name;
        this.duration = duration;
        this.basePrice = basePrice;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                '}';
    }
}
