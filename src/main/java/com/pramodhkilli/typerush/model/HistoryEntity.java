package com.pramodhkilli.typerush.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // link to User entity
    private int wpm;
    private int correctWords;
    private int incorrectWords;
    private double accuracy;
    private int timeElapsed; // in seconds
    private long createdAt;

    public HistoryEntity() {}

    public HistoryEntity(String username, int wpm, int correctWords, int incorrectWords, double accuracy, int timeElapsed,long createdAt) {
        this.username = username;
        this.wpm = wpm;
        this.correctWords = correctWords;
        this.incorrectWords = incorrectWords;
        this.accuracy = accuracy;
        this.timeElapsed = timeElapsed;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWpm() {
        return wpm;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    public int getCorrectWords() {
        return correctWords;
    }

    public void setCorrectWords(int correctWords) {
        this.correctWords = correctWords;
    }

    public int getIncorrectWords() {
        return incorrectWords;
    }

    public void setIncorrectWords(int incorrectWords) {
        this.incorrectWords = incorrectWords;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
