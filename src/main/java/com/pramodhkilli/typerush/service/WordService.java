package com.pramodhkilli.typerush.service;
import java.util.List;

public interface WordService {
    List<String> generateWords(int count, Character targetLetter, int minLength, int maxLength);
    void loadWords();
}
