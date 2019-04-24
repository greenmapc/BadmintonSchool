package ru.kpfu.itis.greenmapc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.greenmapc.model.Group;
import ru.kpfu.itis.greenmapc.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByGroupNumber(int number);
    List<Group> findAllByCoachIs(User coach);

    @Modifying
    @Transactional
    @Query("UPDATE Group SET " +
            "ageCategory = :ageCategory, groupNumber = :groupNumber " +
            "WHERE id = :id")
    void updateGroup(@Param("ageCategory") String ageCategory,
                     @Param("groupNumber") int groupNumber,
                     @Param("id") Long id);
}
