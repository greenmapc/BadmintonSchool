package ru.kpfu.itis.greenmapc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@ToString
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "hash_password")
    private String hashPassword;

    @Column(name = "username", unique = true)
    private String username;


    @Column(name = "test")
    private int test;

    @OneToOne(mappedBy = "login", fetch = FetchType.LAZY)
    @ToString.Exclude private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return id.equals(login.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
