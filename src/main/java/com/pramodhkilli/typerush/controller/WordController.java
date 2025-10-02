package com.pramodhkilli.typerush.controller;
import com.pramodhkilli.typerush.model.WordsRequest;
import com.pramodhkilli.typerush.service.WordService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typerush/words")
@CrossOrigin(origins = "http://localhost:3000")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    /**
     * Generate a list of words for typing practice.
     *
     * @param count       Number of words to generate (default: 50)
     * @param targetLetter Optional letter to target (words containing this letter are weighted)
     * @param minLength   Minimum word length (default: 0 = no minimum)
     * @param maxLength   Maximum word length (default: 0 = no maximum)
     * @return List of generated words
     */
    @PostMapping("/generate")
    public WordsResponse generate(@RequestBody WordsRequest request) {
        Character targetChar = null;
        if (request.getTargetString() != null && !request.getTargetString().isEmpty()) {
            targetChar = request.getTargetString().charAt(0);
        }

        List<String> words = wordService.generateWords(
                request.getCount(),
                targetChar,
                request.getMinLength(),
                request.getMaxLength(),
                request.isCaps()
        );
        return new WordsResponse(words);
    }


    @Data
    static class WordsResponse {
        private List<String> words;
        public WordsResponse(List<String> words) {
            this.words = words;
        }
    }
}

