package main;

import shapes.Shape;
import util.IOUtil;
import util.MyLog;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        boolean logToConsole = false;
        boolean resultToFile = false;

        if (args.length == 0 || !args[0].contains("-")) {
            System.out.println("please provide parameters and output file name");
            displayUsage();
            return;
        }
        if (args[0].equals("-h") || args[0].equals("--help")) {
            displayUsage();
            return;
        }

        for (String arg : args) {
            switch (arg) {
                case "-l":
                    logToConsole = true;
                    break;
                case "-d":
                    resultToFile = false;
                    break;
                case "-f":
                    resultToFile = true;
                    break;
            }
        }

        // поиск первого аргумента после параметров
        String outputFile = Arrays.stream(args).filter(arg -> !arg.contains("-") || arg.length() > 2).findFirst().orElse(null);

        String pathFileInput = "src/main/resources/in";
        String pathFileInput2 = "src/main/resources/in2";
        String pathFileInput3 = "src/main/resources/in3";
        ArrayList<Shape> listShapes = new ArrayList<>();

        //настраиваем вывод лога в зависимости от параметров (по умолчанию пишем в файл)
        MyLog.setLogToFile(logToConsole);

        IOUtil.readShapesFromFile(pathFileInput, listShapes);
        IOUtil.readShapesFromFile(pathFileInput2, listShapes);
        IOUtil.readShapesFromFile(pathFileInput3, listShapes);

        if (!resultToFile) {
            IOUtil.printToConsole(listShapes);
        } else {
            IOUtil.printToFile(listShapes, outputFile);
        }
    }

    private static void displayUsage() {
        System.out.println("Flags are:");
        System.out.println("Usage: PROGRAM [-l] -d | -f [output.txt]");
        System.out.println("    -l log output to the console. Default log write to file");
        System.out.println("    -f result output to the file output.txt");
        System.out.println("    -d result output on display");
        System.out.println("    -h or --help: display this message");
    }
}