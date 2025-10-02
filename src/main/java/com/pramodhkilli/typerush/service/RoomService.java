package com.pramodhkilli.typerush.service;

import com.pramodhkilli.typerush.model.Room;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RoomService {

    private final Map<String, Room> rooms = new HashMap<>();

    public synchronized String createRoom(String username) {
        String roomId = generateRandomRoomId();
        Room room = new Room();
        room.getUsers().put(username, 0);
        rooms.put(roomId, room);
        return roomId;
    }

    public synchronized void joinRoom(String roomId, String username) {
        Room room = rooms.get(roomId);
        if (room != null) {
            room.getUsers().put(username, 0);
        }
    }

    public synchronized void setWords(String roomId, List<String> words) {
        Room room = rooms.get(roomId);
        if (room != null) {
            room.setWords(words);
            room.setStarted(true);
        }
    }

    public synchronized List<String> getWords(String roomId) {
        Room room = rooms.get(roomId);
        if (room != null) return room.getWords();
        return Collections.emptyList();
    }

    public synchronized void updateProgress(String roomId, String username, int wpm) {
        Room room = rooms.get(roomId);
        if (room != null) {
            room.getUsers().put(username, wpm);
        }
    }

    public synchronized Map<String, Integer> getProgress(String roomId) {
        Room room = rooms.get(roomId);
        if (room != null) return room.getUsers();
        return Collections.emptyMap();
    }

    private String generateRandomRoomId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) sb.append(chars.charAt(random.nextInt(chars.length())));
        return sb.toString();
    }
}
