package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
    public static ArrayList<String> getTextFromFile(String pathFile) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(pathFile))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine().toLowerCase());
            }
        }
        return list;
    }

    public static ArrayList<Integer> getNumFromFile(String pathFile) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(pathFile))) {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        }
        return list;
    }
}
