import java.util.Scanner;

public class Main {
    public static boolean isCorrectNum;

    private static double getMulAdd(double[] arr) {
        if (arr.length > 3) System.out.println("Слишком много аргументов, результат для первых трёх");
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
                System.out.println("Неверный формат аргумента в позиции: " + (i));
            }
        }
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
            double[] inputNum = parseInputLine(inputParam);

            switch (operand) {
                case "add":
                    result = getAdd(inputNum);
                    break;
                case "mul":
                    result = getMul(inputNum);
                    break;
                case "maa":
                    result = getMulAdd(inputNum);
                    break;
                default:
                    System.out.println("Неверный формат операции");
            }
        }

        System.out.printf("Результат операции %s: %.2f", operand, result);
    }

    public static void main(String[] args) {
        runInConsole();
    }
}
