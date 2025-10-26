# Text Similarity Checker

This project is a simple Java application that calculates the similarity between two text documents. It uses the cosine similarity algorithm to determine how similar the two documents are and generates a report with the similarity score and the documents with common words highlighted.

## Features

- Calculates the cosine similarity score between two text documents.
- Tokenizes text and removes common English stopwords and punctuation.
- Highlights the common words found in both documents.
- Generates a text-based report with the similarity percentage and highlighted content.

## Directory Structure

- `src/`: Contains the Java source code, organized in the `com.plagiarismchecker` package.
- `input/`: Place your input text files here. The program expects two files named `doc1.txt` and `doc2.txt`.
- `output/`: The generated similarity report (`report.txt`) will be saved in this directory.

## How to Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher must be installed.

### Steps

1.  **Prepare Input Files:**
    Create two text files named `doc1.txt` and `doc2.txt` and place them inside the `input` directory.

2.  **Compile the Code:**
    Open a terminal or command prompt and navigate to the root directory of the project (`Text_Similarity_Checker`). Use the following command to compile the Java source files:

    > **Note:** Most markdown viewers provide a copy button for the code block below.

    ```shell
    javac -d output src/com/plagiarismchecker/*.java
    ```

3.  **Run the Application:**
    After successful compilation, run the application using the following command:

    ```shell
    java -cp output com.plagiarismchecker.Main
    ```

4.  **View the Report:**
    The program will generate a `report.txt` file in the `output` directory. This file contains the similarity score and the highlighted text from both documents.

## Running in Visual Studio Code

1.  **Install Java Extension Pack:**
    Make sure you have the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) from the Visual Studio Code Marketplace installed.

2.  **Open the Project:**
    Open the `Text_Similarity_Checker` folder in Visual Studio Code.

3.  **Run the Application:**
    Open the `src/com/plagiarismchecker/Main.java` file. You will see a "Run" button appear above the `main` method. Click this button to run the application.

    Alternatively, you can open the Run and Debug view from the sidebar and click the "Run and Debug" button.

4.  **Input and Output:**
    Ensure that your input files (`doc1.txt` and `doc2.txt`) are placed in the `input` directory. The output `report.txt` will be generated in the `output` directory.

    > **Note on Commands:** To run the commands mentioned in the "How to Run" section within VS Code's integrated terminal, you can simply select the command text in the README file and use `Ctrl+C` (or `Cmd+C` on Mac) to copy, and then paste it into the terminal.
