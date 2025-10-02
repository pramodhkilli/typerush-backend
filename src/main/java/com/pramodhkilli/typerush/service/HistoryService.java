package com.pramodhkilli.typerush.service;

import com.pramodhkilli.typerush.model.HistoryEntity;
import com.pramodhkilli.typerush.repository.HistoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public HistoryEntity saveHistory(HistoryEntity history) {
        return historyRepository.save(history);
    }

    public List<HistoryEntity> getUserHistory(String username) {
        return historyRepository.findHistoryByUserName(username,10);
    }
}
