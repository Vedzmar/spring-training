package com.epam.training.spring.domains;


public class Theatre extends GenericEntity {

    private String name;
    private int seatsCount;
    private int vipSeatsCount;

    public Theatre(String name, int seatsCount, int vipSeatsCount) {
        super( System.currentTimeMillis() );
        this.name = name;
        this.seatsCount = seatsCount;
        this.vipSeatsCount = vipSeatsCount;
    }

    public String getName() {
        return name;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public int getVipSeatsCount() {
        return vipSeatsCount;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", seatsCount=" + seatsCount +
                ", vipSeatsCount=" + vipSeatsCount +
                '}';
    }
}
