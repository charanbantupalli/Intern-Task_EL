package com.plagiarismchecker;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CosineSimilarity {

    /**
     * Calculates the cosine similarity between two documents.
     * @param termFrequency1 The term frequency map of the first document.
     * @param termFrequency2 The term frequency map of the second document.
     * @return The cosine similarity score.
     */
    public static double calculate(Map<String, Integer> termFrequency1, Map<String, Integer> termFrequency2) {
        // Get the set of all unique terms
        Set<String> terms = new HashSet<>();
        terms.addAll(termFrequency1.keySet());
        terms.addAll(termFrequency2.keySet());

        double dotProduct = 0;
        double magnitude1 = 0;
        double magnitude2 = 0;

        // Calculate the dot product and magnitudes
        for (String term : terms) {
            int freq1 = termFrequency1.getOrDefault(term, 0);
            int freq2 = termFrequency2.getOrDefault(term, 0);

            dotProduct += freq1 * freq2;
            magnitude1 += Math.pow(freq1, 2);
            magnitude2 += Math.pow(freq2, 2);
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        // Avoid division by zero
        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        }

        return dotProduct / (magnitude1 * magnitude2);
    }
}
