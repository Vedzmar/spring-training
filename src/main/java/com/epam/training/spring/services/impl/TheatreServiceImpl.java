package com.epam.training.spring.services.impl;

import com.epam.training.spring.domains.Theatre;
import com.epam.training.spring.services.TheatreService;

import java.util.List;

public class TheatreServiceImpl implements TheatreService {

    private List<Theatre> theatres;

    public TheatreServiceImpl(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public List<Theatre> getAllTheatres() {
        return theatres;
    }

    public Theatre getById(long id) {
        for (Theatre theatre : theatres){
            if (theatre.getId() == id) return theatre;
        }

        return null;
    }
}
