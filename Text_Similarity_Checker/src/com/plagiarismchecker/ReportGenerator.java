package com.plagiarismchecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class ReportGenerator {

    /**
     * Generates a report with the similarity percentage and highlighted documents.
     * @param doc1 The content of the first document.
     * @param doc2 The content of the second document.
     * @param similarity The similarity score.
     * @param commonWords The set of common words.
     * @param outputPath The path to save the report.
     * @throws IOException If an I/O error occurs.
     */
    public static void generateReport(String doc1, String doc2, double similarity, Set<String> commonWords, String outputPath) throws IOException {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Similarity percentage: %.2f%%\n\n", similarity * 100));

        report.append("--- Document 1 ---\n");
        report.append(highlightWords(doc1, commonWords));
        report.append("\n\n--- Document 2 ---\n");
        report.append(highlightWords(doc2, commonWords));

        Files.write(Paths.get(outputPath), report.toString().getBytes());
    }

    /**
     * Highlights the common words in a text.
     * @param text The text to highlight.
     * @param wordsToHighlight The set of words to highlight.
     * @return The highlighted text.
     */
    private static String highlightWords(String text, Set<String> wordsToHighlight) {
        StringBuilder highlightedText = new StringBuilder();
        String[] words = text.split("\\s+");
        for (String word : words) {
            String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            if (wordsToHighlight.contains(cleanWord)) {
                highlightedText.append("**").append(word).append("** ");
            } else {
                highlightedText.append(word).append(" ");
            }
        }
        return highlightedText.toString().trim();
    }
}
