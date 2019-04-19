package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.model.RoleEnum;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MainPageService {

    private UserRepository userRepository;

    public List<User> getAllCoaches() {
        return userRepository.findAllByRole(RoleEnum.COACH.name());
    }

    public List<User> getAllAthletes() {
        return userRepository.findAllByRole(RoleEnum.ATHLETE.name());
    }

    public List<User> getAllCoachesByCriteria(String searchString) {
        searchString = searchString.trim();
        String[] words = searchString.split(" ");
        Set<User> userSet = new HashSet<>();

        for(String word : words) {
            userSet.addAll(userRepository.findAllLikeWord(RoleEnum.COACH.name(), word + "%"));
        }
        return new ArrayList<>(userSet);
    }

    public List<User> getAllAthletesByCriteria(String searchString) {
        searchString = searchString.trim();
        String[] words = searchString.split(" ");
        Set<User> userSet = new HashSet<>();

        for(String word : words) {
            userSet.addAll(userRepository.findAllLikeWord(RoleEnum.ATHLETE.name(), word + "%"));
        }
        return new ArrayList<>(userSet);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
