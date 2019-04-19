package ru.kpfu.itis.greenmapc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.greenmapc.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
