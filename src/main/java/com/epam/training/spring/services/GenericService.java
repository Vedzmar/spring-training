package com.epam.training.spring.services;

/**
 * Created by Dzianis on 25.10.2015.
 */
public  interface GenericService<T> {

    T getById(long id);
}
