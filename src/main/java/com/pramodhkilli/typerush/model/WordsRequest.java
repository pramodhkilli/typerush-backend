package com.pramodhkilli.typerush.model;
public class WordsRequest {
    private int count = 50;
    private String targetString; // optional
    private int minLength = 0;
    private int maxLength = 0;
    private boolean caps;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTargetString() {
        return targetString;
    }

    public void setTargetString(String targetString) {
        this.targetString = targetString;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isCaps() {
        return caps;
    }

    public void setCaps(boolean caps) {
        this.caps = caps;
    }
}
