package OOP.main;

import OOP.data.DataInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataInput dataInput = new DataInput();
        Scanner scanner = new Scanner(System.in);
        while (!dataInput.isCorrectArgs()) {
            System.out.print("Введите операцию и аргументы: ");
            dataInput.parseData(scanner.nextLine());
        }

        System.out.printf("Результат операции %s: %.2f", dataInput.getOperand(), dataInput.getResult());
    }

}
