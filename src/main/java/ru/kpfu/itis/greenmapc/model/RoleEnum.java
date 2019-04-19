package ru.kpfu.itis.greenmapc.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    COACH, ATHLETE;

    @Override
    public String getAuthority() {
        return name();
    }
}
