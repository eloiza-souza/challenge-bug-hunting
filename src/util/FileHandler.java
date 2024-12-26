package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private File file;

    public FileHandler(String filePath) {
        this.file = new File(filePath);
    }

    public void writeInFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public List<String> readLinesFromFile() {
        List<String> linesFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
                linesFromFile.add(line);
        } catch (IOException e) {
            System.err.println("Erro ao ler os dados: " + e.getMessage());
        }
        return linesFromFile;
    }
}