package com.pramodhkilli.typerush.controller;

import com.pramodhkilli.typerush.model.UserProgress;
import com.pramodhkilli.typerush.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/typerush/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public Map<String, String> createRoom(@RequestParam String username) {
        String roomId = roomService.createRoom(username);
        return Map.of("roomId", roomId);
    }

    @PostMapping("/join")
    public void joinRoom(@RequestParam String roomId, @RequestParam String username) {
        roomService.joinRoom(roomId, username);
    }

    @PostMapping("/setWords")
    public void setWords(@RequestParam String roomId, @RequestBody List<String> words) {
        roomService.setWords(roomId, words);
    }

    @GetMapping("/words")
    public List<String> getWords(@RequestParam String roomId) {
        return roomService.getWords(roomId);
    }

    @PostMapping("/progress")
    public void updateProgress(@RequestParam String roomId, @RequestParam String username, @RequestParam int wpm) {
        roomService.updateProgress(roomId, username, wpm);
    }

    @GetMapping("/progress")
    public Map<String, Integer> getProgress(@RequestParam String roomId) {
        return roomService.getProgress(roomId);
    }
}

