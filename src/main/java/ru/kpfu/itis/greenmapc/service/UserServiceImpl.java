package ru.kpfu.itis.greenmapc.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.greenmapc.form.SettingsForm;
import ru.kpfu.itis.greenmapc.form.SignUpForm;
import ru.kpfu.itis.greenmapc.model.Login;
import ru.kpfu.itis.greenmapc.model.RoleEnum;
import ru.kpfu.itis.greenmapc.model.User;
import ru.kpfu.itis.greenmapc.repository.UserRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean signUp(SignUpForm form) {
        Set<RoleEnum> roleSet = new HashSet<>();

        if(form.getLogin().equals("admin")) {
            roleSet.add(RoleEnum.ADMIN);

        } else {
            roleSet.add(RoleEnum.valueOf(form.getType().toUpperCase()));
        }

        Login login = new Login();
        login.setUsername(form.getLogin());
        login.setHashPassword(passwordEncoder.encode(form.getPassword()));

        User user = new User();
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setRoles(roleSet);
        user.setLogin(login);

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<User> findUserByLogin(String username) {
        return Optional.ofNullable(userRepository.findOneByUsername(username));
    }

    @Override
    public void update(User user, SettingsForm form) {
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setPatronymic(form.getPatronymic());
        user.setContactNumber(form.getNumber());

        if(user.getRoles().contains(RoleEnum.COACH) && form.getChoosingGroups() != null) {
            user.getGroups().addAll(new HashSet<>(form.getChoosingGroups()));
        }

        if(user.getRoles().contains(RoleEnum.ATHLETE) && form.getChoosingGroup() != null) {
            user.setGroup(form.getChoosingGroup());
        }

        if(form.getBirthday() != null && !form.getBirthday().isEmpty()) {
            user.setBirthday(LocalDate.parse(form.getBirthday()));
        }

        userRepository.update(user);
    }
}
