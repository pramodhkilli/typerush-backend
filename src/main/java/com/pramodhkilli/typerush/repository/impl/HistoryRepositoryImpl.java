package com.pramodhkilli.typerush.repository.impl;

import com.pramodhkilli.typerush.model.HistoryEntity;
import com.pramodhkilli.typerush.repository.HistoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HistoryEntity> findHistoryByUserName(String username,int limit) {
        List<HistoryEntity> history = null;
        try {
            history = entityManager.createQuery(
                            "SELECT h FROM HistoryEntity h where h.username =:username order by h.createdAt desc limit "+limit,
                            HistoryEntity.class
                    )
                    .setParameter("username",username)
                    .setMaxResults(limit)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return history;
    }

    @Override
    @Transactional
    public HistoryEntity save(HistoryEntity historyEntity) {
        if (historyEntity.getId() == null) {
            entityManager.persist(historyEntity); // new entity
            return historyEntity;
        } else {
            return entityManager.merge(historyEntity); // existing entity update
        }
    }
}
