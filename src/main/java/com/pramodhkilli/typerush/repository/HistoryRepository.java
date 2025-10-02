package com.pramodhkilli.typerush.repository;

import com.pramodhkilli.typerush.model.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoryRepository{

    List<HistoryEntity> findHistoryByUserName(String username,int limit);

    HistoryEntity save(HistoryEntity history);
}
