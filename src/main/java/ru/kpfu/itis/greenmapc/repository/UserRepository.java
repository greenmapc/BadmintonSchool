package ru.kpfu.itis.greenmapc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.greenmapc.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    @Query(value = "SELECT u FROM User u " +
            "JOIN u.login l " +
            "JOIN u.roles " +
            "LEFT JOIN u.group " +
            "LEFT JOIN u.groups " +
            "WHERE l.username = :username")
    User findOneByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u " +
            "JOIN u.login l " +
            "JOIN u.roles r " +
            "WHERE :role IN(r) " +
            "ORDER BY l.username")
    List<User> findAllByRole(@Param("role") String role);

    @Query(value = "SELECT u FROM User u " +
            "JOIN u.login l " +
            "JOIN u.roles r " +
            "WHERE :role IN(r) AND ( " +
            "l.username LIKE :word OR u.name LIKE :word OR u.surname LIKE :word OR u.patronymic LIKE :word)")
    List<User> findAllLikeWord(@Param("role") String role, @Param("word") String word);

}