package ru.kpfu.itis.greenmapc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.form.SettingsForm;
import ru.kpfu.itis.greenmapc.form.SignUpForm;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean signUp(SignUpForm form);

    Optional<User> findUserByLogin(String username);

    void update(User user, SettingsForm form);
}
