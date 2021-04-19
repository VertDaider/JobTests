package sort;

import util.FileLoader;

import java.io.IOException;
import java.util.ArrayList;

public class IntegerData {
    ArrayList<Integer> list;
    String pathFile;

    public IntegerData(String pathFile) throws IOException {
        this.pathFile = pathFile;
        list = FileLoader.getNumFromFile(pathFile);
    }

    public ArrayList<Integer> getList() {
        return list;
    }


    public boolean isSorted() {
        if(list.size() == 1) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i+ 1)) {
                return false;
            }
        }
        return true;
    }
}
