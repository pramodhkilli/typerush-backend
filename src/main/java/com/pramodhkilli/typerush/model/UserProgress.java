package com.pramodhkilli.typerush.model;

public class UserProgress {
    private String username;
    private int wpm;

    // Constructors
    public UserProgress() {}
    public UserProgress(String username, int wpm) {
        this.username = username;
        this.wpm = wpm;
    }

    // Getters & setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public int getWpm() { return wpm; }
    public void setWpm(int wpm) { this.wpm = wpm; }
}

