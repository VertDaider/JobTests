package procedure;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger log;

    static {
        try (FileInputStream ins = new FileInputStream("src/log.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
            log = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static boolean isCorrectNum;

    private static double getMulAdd(double[] arr) {
        if (arr.length > 3) System.out.println("Слишком много аргументов, результат для первых трёх");
        if (arr.length < 3) throw new IndexOutOfBoundsException();
        return (arr[0] * arr[1]) + arr[2];
    }

    private static double getMul(double[] arr) {
        double result = 1;
        for (double v : arr) {
            result *= v;
        }
        return result;
    }

    private static double getAdd(double[] arr) {
        double result = 0;
        for (double v : arr) {
            result += v;
        }
        return result;
    }

    private static double[] parseInputLine(String[] inputParam) {
        double[] arr = new double[inputParam.length - 1];
        int correctNumCount = 0;
        for (int i = 1; i < inputParam.length; i++) {
            try {
                arr[i - 1] = Double.parseDouble(inputParam[i]);
                correctNumCount++;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат аргумента в позиции: " + i);
            }
        }
        // проверяем все аргументы на корректное значение
        if (correctNumCount == arr.length) isCorrectNum = true;
        return arr;
    }

    private static void runInConsole() {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        String operand = null;
        while (!isCorrectNum) {
            System.out.print("Введите операцию и аргументы: ");
            String s = scanner.nextLine();
            String[] inputParam = s.split(" ");
            operand = inputParam[0];
            result = getResult(inputParam);
        }

        System.out.printf("Результат операции %s: %.2f", operand, result);
    }

    private static double getResult(String[] inputParam) {
        double[] inputNum = parseInputLine(inputParam);
        double result = 0;
        switch (inputParam[0]) {
            case "add":
                result = getAdd(inputNum);
                break;
            case "mul":
                result = getMul(inputNum);
                break;
            case "maa":
                try {
                    result = getMulAdd(inputNum);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Слишком мало аргументов для данной операции");
                    isCorrectNum = false;
                }
                break;
            default:
                System.out.println("Неверный формат операции");
                isCorrectNum = false;
        }
        return result;
    }

    private static void displayUsage() {
        System.out.println("Flags are:");
        System.out.println("Usage: PROGRAM - | input.txt output.txt");
        System.out.println("    i/o.txt result write from input.txt and output to the file output.txt");
        System.out.println("    -  result output on display");
        System.out.println("    -h or --help: display this message");
    }

    private static void runIOFile(String inputFile, String outputFile) {
        String operand = null;
        double result = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] inputParam = s.split(" ");
                result = getResult(inputParam);
                operand = inputParam[0];
            }
        } catch (Exception e) {
            log.info("File not found");
            return;
        }

        if (isCorrectNum) {
            System.out.printf("Результат операции %s: %.2f", operand, result);
        } else {
            System.out.println("Результат не получен, проверьте правильность данных в файле");
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("please provide parameters and output file name");
            displayUsage();
            return;
        }
        if (args[0].equals("-h") || args[0].equals("--help")) {
            displayUsage();
            return;
        }
        if (args.length == 1 && args[0].equals("-")) {
            runInConsole();
            return;
        }

        String inputFile = null;
        String outputFile = null;
        if (args.length == 2) {
            inputFile = args[0];
            outputFile = args[1];
        }

        if (inputFile != null && outputFile != null) {
            runIOFile(inputFile, outputFile);
        }
    }


}
