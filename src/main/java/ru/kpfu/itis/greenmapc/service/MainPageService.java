package ru.kpfu.itis.greenmapc.service;

import ru.kpfu.itis.greenmapc.model.User;

import java.util.List;

public interface MainPageService {
    List<User> getAllCoaches();
    List<User> getAllAthletes();

    List<User> getAllCoachesByCriteria(String searchString);
    List<User> getAllAthletesByCriteria(String searchString);


}
