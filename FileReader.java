import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private Graph graph;

    // Constructor initializing the graph
    public FileReader() {
        graph = new Graph();
    }

    // Method to load a graph from a file
    public Graph loadGraphFromFile(String filePath) {
        File file = new File(filePath);

        // Check if file exists before proceeding
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return null;
        }

        // Using try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Skip empty lines or malformed lines
                if (line.isEmpty()) continue;

                String[] tokens = line.split("\\s+");

                // Ensure line has exactly two elements to form an edge
                if (tokens.length == 2) {
                    try {
                        int person1 = Integer.parseInt(tokens[0]);
                        int person2 = Integer.parseInt(tokens[1]);
                        graph.addEdge(person1, person2);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in line: " + line);
                    }
                } else {
                    System.out.println("Malformed line (expected two numbers): " + line);
                }
            }
            System.out.println("Graph loaded successfully!");
            return graph;
        } catch (FileNotFoundException e) {
            // Handle unexpected file not found exception
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}


