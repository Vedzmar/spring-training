package com.epam.training.spring.domains;

import java.util.Date;


public class User extends GenericEntity {

    private String email;
    private String name;
    private Date birthday;

    public User(String email, String name, Date birthday) {
        super( System.currentTimeMillis() );
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
