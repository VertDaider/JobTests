package dovgopolov.Main;

import dovgopolov.Animals;
import dovgopolov.Flying;
import dovgopolov.Walking;
import dovgopolov.Waterfowl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int countMovesIsNoHungry = 20;

    private static void animalsEating(ArrayList<Animals> list) {
        for (int j = 0; j < list.size() - 1; j++) {
            for (int i = j + 1; i < list.size(); i++) {
                if (list.get(j).getX() == list.get(i).getX() && list.get(j).getY() == list.get(i).getY() &&
                        list.get(i).getClass() != list.get(j).getClass()) {
                    if (list.get(j).getSize() > list.get(i).getSize()) {
                        list.get(j).soundEatUp();
                        list.get(i).soundWhenEatMe();
                        list.remove(i);
                        list.get(j).setHungry(false);
                        list.get(j).setCountMoves(countMovesIsNoHungry);
                        list.get(j).setSize(list.get(j).getSize() + 1);
                    } else if (list.get(j).getSize() < list.get(i).getSize()) {
                        list.get(i).soundEatUp();
                        list.get(j).soundWhenEatMe();
                        list.remove(j);
                        list.get(i).setHungry(false);
                        list.get(i).setCountMoves(countMovesIsNoHungry);
                        list.get(i).setSize(list.get(j).getSize() + 1);
                    }
                }
            }
        }
    }

    private static void search(int choice, ArrayList<Animals> list, String name) {
        switch (choice) {
            case 1:                                         //не находит кличку если есть пробел в имени
                boolean isFoundName = false;
                for (Animals aList : list) {
                    if (name.contains(aList.getName())) {
                        System.out.println(aList.getName());
                        isFoundName = true;
                    }
                }
                if (!isFoundName) {
                    System.out.println("Животных с такой кличкой не найдено");
                }
                break;
            case 2:
                boolean isHungry = false;
                for (Animals beast : list) {
                    if (beast.isHungry()) {
                        System.out.println(beast.getName());
                        isHungry = true;
                    }
                }
                if (!isHungry) {
                    System.out.println("Голодающих пока нет");
                }
                break;
            case 3:
                for (Animals beast : list) {
                    beast.getAllParameters();
                }
                break;
            default:
                System.out.println("Неверный параметр");
        }
    }

    public static void main(String[] args) {
        int defaultX = 10;
        int defaultY = 10;

        Walking wolf = new Walking("Серый волк", "серый", 5, defaultX, defaultY, countMovesIsNoHungry, 4, 4);
        Walking dog = new Walking("Мухтар", "коричневый", 4, defaultX, defaultY, countMovesIsNoHungry, 4, 3);
        Waterfowl gus = new Waterfowl("Гусь Хиддинг", "белый", 2, defaultX, defaultY, countMovesIsNoHungry);
        Flying bee = new Flying("Пчела", "желтый", 1, defaultX, defaultY, countMovesIsNoHungry);

        ArrayList<Animals> AnimalsIsland = new ArrayList<>();
        AnimalsIsland.add(wolf);
        AnimalsIsland.add(gus);
        AnimalsIsland.add(bee);
        AnimalsIsland.add(dog);

        gus.setX(2);

        animalsEating(AnimalsIsland);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметр поиска:\n1 - Поиск по кличке\n2 - поиск голодающих животных\n3 - Показать всех животных с параметрами");
        int choiceNumber = scanner.nextInt();
        String nameAnimal = " ";

        if (choiceNumber == 1) {
            System.out.println("Введите кличку животного: ");
            nameAnimal = scanner.next();
        }

        search(choiceNumber, AnimalsIsland, nameAnimal);

    }
}