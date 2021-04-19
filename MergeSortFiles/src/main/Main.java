package main;

import sort.IntegerData;
import sort.TextData;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

//    private static final String test = "./src/data/dataTest";

    private static final String fileText1 = "./src/data/dataString1";
    private static final String fileText2 = "./src/data/dataString2";

    private static final String fileNumbers1 = "./src/data/dataInt1";
    private static final String fileNumbers2 = "./src/data/dataInt2";

    public static void main(String[] args) throws IOException {
        boolean isNumeric;
        boolean isText;
        boolean decrease;
        String outputfile;
//        String[] args = new String[args.length];
        ArrayList<String> inputFiles = new ArrayList<>();


        if (args.length < 3 || !args[0].contains("-")) {
            System.out.println("please provide parameters and input and output file names");
            displayUsage();
            return;
        }
        if (args[0].equals("-h")) {
            displayUsage();
            return;
        }

        for (String arg : args) {
            switch (arg) {
                case "-a":
                    decrease = false;
                    break;
                case "-d":
                    decrease = true;
                    break;
                case "-s":
                    isText = true;
                    isNumeric = false;
                    break;
                case "-i":
                    isText = false;
                    isNumeric = true;
                    break;
//                default:
//                    displayUsage();
            }
        }

        // поиск первого аргумента после параметров
        outputfile = Arrays.stream(args).filter(arg -> !arg.contains("-") || arg.length() > 2).findFirst().orElse(null);
        // поиск последующих аргументов
        boolean firstFile = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(outputfile)) {
                firstFile = true;
                i++;
            }
            if (firstFile) {
                inputFiles.add(args[i]);
            }
        }

        System.out.println(outputfile);
        System.out.println(inputFiles.toString());

        Comparator<String> comparator = defaultcomparator;

        IntegerData dataNum1 = new IntegerData(fileNumbers1);
        IntegerData dataNum2 = new IntegerData(fileNumbers2);

        TextData textData1 = new TextData(fileText1);
        TextData textData2 = new TextData(fileText2);

        System.out.println(dataNum1.isSorted());
        System.out.println(textData1.isSorted());


        File fileResult = new File("./src/data/" + outputfile);
        try {
            boolean created = fileResult.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

//        mergeSort(fileNumbers1, fileNumbers2, fileResult.getPath());

    }


    private static void displayUsage() {
        System.out.println("Flags are:");
        System.out.println("Usage: PROGRAM [-a | -d] -s | -i output.txt inputfiles.txt...");
        System.out.println("-h or --help: display this message");
    }


    // слияние числовых данных
    public static void mergeSort(String file1, String file2, String resultPath) throws IOException {
        IntegerData dataNum1 = new IntegerData(file1);
        IntegerData dataNum2 = new IntegerData(file2);

        int size1 = dataNum1.getList().size();
        int size2 = dataNum2.getList().size();

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < size1 || j < size2) {

            if (i >= size1) {
                result.add(dataNum2.getList().get(j));
                j++;
            } else if (j >= size2) {
                result.add(dataNum1.getList().get(i));
                i++;
            } else if (dataNum1.getList().get(i) < dataNum2.getList().get(j)) {
                result.add(dataNum1.getList().get(i));
                i++;
            } else {
                result.add(dataNum2.getList().get(j));
                j++;
            }
        }

        writeToFile(result, resultPath);
    }

    private static void writeToFile(ArrayList<Integer> list, String pathFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(pathFile)) {
            for (Integer e : list) {
                writer.println(e);
            }
        }
    }

    public static Comparator<String> defaultcomparator = new Comparator<String>() {
        @Override
        public int compare(String r1, String r2) {
            return r1.compareTo(r2);
        }
    };

}
