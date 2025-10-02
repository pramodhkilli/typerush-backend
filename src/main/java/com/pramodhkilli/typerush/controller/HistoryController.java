package com.pramodhkilli.typerush.controller;

import com.pramodhkilli.typerush.model.HistoryEntity;
import com.pramodhkilli.typerush.service.HistoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/typerush")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping("/saveHistory")
    public HistoryEntity saveHistory(@RequestBody HistoryEntity history) {
        return historyService.saveHistory(history);
    }

    @PostMapping("/getHistory")
    public List<HistoryEntity> getUserHistory(@RequestBody Map<String,String> HistoryData) {
        return historyService.getUserHistory(HistoryData.get("username"));
    }
}
