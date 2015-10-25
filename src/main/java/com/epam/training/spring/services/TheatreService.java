package com.epam.training.spring.services;

import com.epam.training.spring.domains.Theatre;

import java.util.List;

public interface TheatreService extends GenericService<Theatre> {

    List<Theatre> getAllTheatres();
}
