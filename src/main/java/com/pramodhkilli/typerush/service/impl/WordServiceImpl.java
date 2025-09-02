package com.pramodhkilli.typerush.service.impl;
import com.pramodhkilli.typerush.service.WordService;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

    @Getter
    private List<String> wordList = new ArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void loadWords() {
        try (InputStream inputStream = getClass().getResourceAsStream("/static/words.txt")) {
            if (inputStream != null) {
                wordList = new BufferedReader(new InputStreamReader(inputStream))
                        .lines()
                        .filter(line -> !line.trim().isEmpty())
                        .collect(Collectors.toList());
            } else {
                wordList = Collections.emptyList();
            }
        } catch (Exception e) {
            System.out.println("there was an error while fetching words from library");
        }
        System.out.println("✅ Loaded " + wordList.size() + " words into memory");
    }

    @Override
    public List<String> generateWords(int count, Character targetLetter, int minLength, int maxLength) {
        List<String> filtered = wordList.stream()
                .filter(w -> minLength <= 0 || w.length() >= minLength)
                .filter(w -> maxLength <= 0 || w.length() <= maxLength)
                .filter(w -> targetLetter == null || w.indexOf(Character.toLowerCase(targetLetter)) >= 0)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> weighted = new ArrayList<>();
        for (String w : filtered) {
            long freq = targetLetter != null
                    ? w.chars().filter(c -> c == Character.toLowerCase(targetLetter)).count()
                    : 1;
            for (int i = 0; i < Math.max(1, freq); i++) {
                weighted.add(w);
            }
        }

        Collections.shuffle(weighted);

        // Return exactly 'count' words (or less if not enough words available)
        return weighted.stream()
                .limit(count)
                .collect(Collectors.toList());
    }


    // Helper class for Datamuse API response
    private static class DatamuseWord {
        private String word;
        public String getWord() { return word; }
        public void setWord(String word) { this.word = word; }
    }
}



