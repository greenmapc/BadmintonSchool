package ru.kpfu.itis.greenmapc.repository;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.greenmapc.model.VkWallRecord;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("vkWallRecordRepositoryCustomImpl")
public class VkWallRecordRepositoryCustomImpl implements VkWallRecordRepositoryCustom {

    private final static String JPQL_FIND_TOP_BY_DATE_QUERY = "FROM VkWallRecord r ORDER BY r.date DESC";

    @PersistenceContext
    private EntityManager entityManager;


    public VkWallRecord findTopByDate() {
        return entityManager.createQuery(JPQL_FIND_TOP_BY_DATE_QUERY, VkWallRecord.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    public List<VkWallRecord> findAllPagination(int offset, int limit) {
        return entityManager.createQuery("FROM VkWallRecord r ORDER BY r.date DESC", VkWallRecord.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

    }

}
