# Project Report - Text Similarity Checker

## 1. Introduction
This project implements a simple Text Similarity Checker using Java. It calculates the cosine similarity between two input text documents, identifies common words, and generates a human-readable report highlighting these commonalities.

## 2. Architecture and Components

The project is structured into several key Java classes, each responsible for a specific part of the text similarity calculation and reporting process:

*   **`Main.java`**: The entry point of the application. It orchestrates the entire process, from reading input files to generating the final report.
*   **`TextProcessor.java`**: Handles the preprocessing of text documents. This includes tokenization, converting text to lowercase, removing punctuation, and filtering out common English stopwords. It also calculates the term frequency for a given list of tokens.
*   **`CosineSimilarity.java`**: Implements the core logic for calculating the cosine similarity between two documents based on their term frequency maps.
*   **`ReportGenerator.java`**: Responsible for formatting and writing the similarity report to a file. It highlights common words in the input documents to visually represent the areas of similarity.

## 3. Key Functionalities

The Text Similarity Checker performs the following steps:

1.  **Text Preprocessing**:
    *   Reads two input text files (`input/doc1.txt` and `input/doc2.txt`).
    *   Converts all text to lowercase.
    *   Removes punctuation.
    *   Splits the text into individual words (tokens).
    *   Removes a predefined list of common English stopwords (e.g., "a", "the", "is").
2.  **Term Frequency Calculation**:
    *   For each preprocessed document, it creates a map where keys are unique words and values are their frequencies in the document.
3.  **Cosine Similarity Calculation**:
    *   Uses the term frequency maps to calculate the cosine similarity score, which is a measure of similarity between two non-zero vectors of an inner product space.
    *   A score of 1 indicates identical documents, while 0 indicates no common words.
4.  **Report Generation**:
    *   Generates a report (`output/report.txt`) that includes:
        *   The calculated similarity percentage.
        *   The content of both input documents with common words highlighted in bold.

## 4. Usage

To run this project:

1.  Ensure you have Java Development Kit (JDK) installed.
2.  Place your input text files (e.g., `doc1.txt`, `doc2.txt`) in the `input/` directory.
3.  Compile the Java source files:
    ```bash
    javac -d output src/com/plagiarismchecker/*.java
    ```
4.  Run the main application:
    ```bash
    java -cp output com.plagiarismchecker.Main
    ```
5.  The report will be generated in `output/report.txt`.

## 5. Example Output

Below is an example of the content found in `output/report.txt` after running the application with sample inputs:

```
Similarity percentage: 75.00%

--- Document 1 ---
This **project** **belongs** **to** Chandra.

--- Document 2 ---
This **project** **belongs** **to** Charan.
```

## 6. Conclusion

The Text Similarity Checker provides an effective way to compare two text documents and quantify their similarity based on the cosine similarity algorithm. The generated report offers a clear overview of the similarity score and visually highlights shared content, making it easy to understand the commonalities between the documents.
