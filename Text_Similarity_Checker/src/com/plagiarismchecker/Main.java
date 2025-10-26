package com.plagiarismchecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        // Define the paths for the input documents
        String doc1Path = "C:\\Users\\Charan\\Documents\\EL_INTERN_TASKS\\Text_Similarity_Checker\\input\\doc1.txt";
        String doc2Path = "C:\\Users\\Charan\\Documents\\EL_INTERN_TASKS\\Text_Similarity_Checker\\input\\doc2.txt";

        // Read the content of the documents
        String content1 = new String(Files.readAllBytes(Paths.get(doc1Path)));
        String content2 = new String(Files.readAllBytes(Paths.get(doc2Path)));

        // Tokenize the content and remove stopwords
        List<String> tokens1 = TextProcessor.tokenizeAndRemoveStopwords(content1);
        List<String> tokens2 = TextProcessor.tokenizeAndRemoveStopwords(content2);

        // Calculate the term frequency for each document
        Map<String, Integer> termFrequency1 = TextProcessor.getTermFrequency(tokens1);
        Map<String, Integer> termFrequency2 = TextProcessor.getTermFrequency(tokens2);

        // Calculate the cosine similarity between the two documents
        double similarity = CosineSimilarity.calculate(termFrequency1, termFrequency2);

        // Find the common words between the two documents
        Set<String> commonWords = new HashSet<>(tokens1);
        commonWords.retainAll(new HashSet<>(tokens2));

        // Generate the report
        String outputPath = "C:\\Users\\Charan\\Documents\\EL_INTERN_TASKS\\Text_Similarity_Checker\\output\\report.txt";
        ReportGenerator.generateReport(content1, content2, similarity, commonWords, outputPath);

        System.out.println("Report generated successfully at: " + outputPath);


    }
}
