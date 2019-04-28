package ru.kpfu.itis.greenmapc.service;

import ru.kpfu.itis.greenmapc.form.SettingsForm;
import ru.kpfu.itis.greenmapc.form.SignUpForm;
import ru.kpfu.itis.greenmapc.model.User;


import java.util.Optional;

public interface UserService {
    User signUp(SignUpForm form);

    Optional<User> findUserByLogin(String username);

    void update(User user, SettingsForm form);
}
