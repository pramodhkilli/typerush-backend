package com.pramodhkilli.typerush.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private String roomId;
    private Map<String, Integer> users; // username -> WPM
    private List<String> words; // words for the typing test
    private boolean started; // indicates if the test has started

    // Default constructor
    public Room() {
        this.users = new HashMap<>();
        this.started = false;
    }

    // Constructor with roomId
    public Room(String roomId) {
        this.roomId = roomId;
        this.users = new HashMap<>();
        this.started = false;
    }

    // Full constructor
    public Room(String roomId, Map<String, Integer> users, List<String> words, boolean started) {
        this.roomId = roomId;
        this.users = users;
        this.words = words;
        this.started = started;
    }

    // Getters and setters
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Map<String, Integer> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Integer> users) {
        this.users = users;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    // Convenience method to add a user
    public void addUser(String username) {
        this.users.putIfAbsent(username, 0);
    }

    // Convenience method to update progress
    public void updateProgress(String username, int wpm) {
        if (this.users.containsKey(username)) {
            this.users.put(username, wpm);
        }
    }
}
