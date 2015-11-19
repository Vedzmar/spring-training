package com.epam.training.spring.aspects;


import com.epam.training.spring.domains.Showing;

public interface ShowingCounter {
    long getAccessCount(Showing showing);
    long getBookCount(Showing showing);
}
