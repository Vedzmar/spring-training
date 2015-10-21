package com.epam.training.spring.domains;

/**
 * Created by Dzianis_Sudas on 10/21/2015.
 */
public class User {
    
    private long id;
    private String email;
    private String name;

    public User(String email, String name) {
        this.id = System.currentTimeMillis();
        this.email = email;
        this.name = name;
    }

    public User(long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
