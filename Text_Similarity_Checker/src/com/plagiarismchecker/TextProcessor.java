package com.plagiarismchecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessor {

    // List of common English stopwords
    private static final List<String> STOP_WORDS = Arrays.asList("a", "an", "and", "the", "in", "on", "of", "is", "it", "this", "that");

    /**
     * Tokenizes the text, removes punctuation and stopwords.
     * @param text The input text.
     * @return A list of tokens.
     */
    public static List<String> tokenizeAndRemoveStopwords(String text) {
        // Convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\s]", "");
        // Split into tokens
        List<String> tokens = new ArrayList<>(Arrays.asList(text.split("\\s+")));
        // Remove stopwords
        tokens.removeAll(STOP_WORDS);
        return tokens;
    }

    /**
     * Calculates the term frequency of each token.
     * @param tokens A list of tokens.
     * @return A map of tokens and their frequencies.
     */
    public static Map<String, Integer> getTermFrequency(List<String> tokens) {
        Map<String, Integer> termFrequency = new HashMap<>();
        for (String token : tokens) {
            termFrequency.put(token, termFrequency.getOrDefault(token, 0) + 1);
        }
        return termFrequency;
    }
}
