package sort;

import util.FileLoader;

import java.io.IOException;
import java.util.*;

public class TextData {
    ArrayList<String> list;
    String pathFile;

    public TextData(String pathFile) throws IOException {
        this.pathFile = pathFile;
        list = FileLoader.getTextFromFile(pathFile);
    }

    public boolean isSorted() {
        if(list.size() == 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public List<String> getList() {
        return list;
    }
}