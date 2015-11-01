package com.epam.training.spring.aspects;


import com.epam.training.spring.domains.Showing;

public interface ShowingCounter {
    int getAccessCount(Showing showing);
    int getBookCount(Showing showing);
}
