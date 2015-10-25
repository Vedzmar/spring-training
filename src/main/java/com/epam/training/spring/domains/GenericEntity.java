package com.epam.training.spring.domains;

/**
 * Created by Dzianis on 25.10.2015.
 */
public abstract class GenericEntity {
    protected long id;

    public long getId() {
        return id;
    }

    protected GenericEntity(long id) {
        this.id = id;
    }
}
