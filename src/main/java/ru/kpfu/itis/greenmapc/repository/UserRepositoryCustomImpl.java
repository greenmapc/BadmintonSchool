package ru.kpfu.itis.greenmapc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.greenmapc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository("userRepositoryCustomImpl")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final String JPQL_UPDATE_USER_QUERY = "UPDATE User u SET u.birthday = :birthday, u.contactNumber = :number, " +
            "u.email = :email, u.name = :name, u.patronymic = :patronymic, " +
            "u.surname = :surname, u.group = :group " +
            "WHERE u.id = :id";

    private final String JPQL_UPDATE_GROUP_QUERY  = "UPDATE Group g SET g.coach = :user WHERE g IN :groupList";

    private EntityManagerFactory entityManagerFactory;


    public void update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery(JPQL_UPDATE_USER_QUERY)
                .setParameter("birthday", user.getBirthday())
                .setParameter("number", user.getContactNumber())
                .setParameter("email", user.getEmail())
                .setParameter("name", user.getName())
                .setParameter("patronymic", user.getPatronymic())
                .setParameter("surname", user.getSurname())
                .setParameter("id", user.getId())
                .setParameter("group", user.getGroup())
                .executeUpdate();

        if(user.getGroups() != null && !user.getGroups().isEmpty()) {
            entityManager.createQuery(JPQL_UPDATE_GROUP_QUERY)
                    .setParameter("user", user)
                    .setParameter("groupList", user.getGroups())
                    .executeUpdate();
        }
        entityManager.getTransaction().commit();
    }

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
