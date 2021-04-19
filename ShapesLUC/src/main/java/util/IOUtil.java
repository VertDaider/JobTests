package util;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IOUtil {
    public static void readShapesFromFile(String pathFileInput, ArrayList<Shape> listShapes) {
        try (Scanner scanner = new Scanner(new FileInputStream(pathFileInput))) {
            while (scanner.hasNext()) {
                String type = scanner.nextLine();
                switch (type) {

                    case "CIRCLE":
                        try {
                            double radius = scanner.nextDouble();
                            listShapes.add(new Circle(radius));
                        } catch (Exception e) {
                            MyLog.getLogger().error("Catch exception", e);
                            break;
                        }
                        break;

                    case "RECTANGLE":
                        try {
                            String[] line = scanner.nextLine().split(" ");
                            if (line.length != 2) break;
                            double a = Double.parseDouble(line[0]);
                            double b = Double.parseDouble(line[1]);
                            listShapes.add(new Rectangle(a, b));
                        } catch (Exception e) {
                            MyLog.getLogger().error("Catch exception", e);
                            break;
                        }
                        break;

                    case "TRIANGLE":
                        try {
                            String[] line = scanner.nextLine().split(" ");
                            if (line.length != 3) break;
                            double x = Double.parseDouble(line[0]);
                            double y = Double.parseDouble(line[1]);
                            double z = Double.parseDouble(line[2]);
                            listShapes.add(new Triangle(x, y, z));
                        } catch (Exception e) {
                            MyLog.getLogger().error("Catch exception", e);
                            break;
                        }
                        break;
//                    default:
//                        MyLog.getLogger().error(String.format("Unknown shape type in file: %s. Shape not added", pathFileInput));
                }
            }
        } catch (Exception e) {
            MyLog.getLogger().error(String.format("File %s not found", pathFileInput), e);
        }

        listShapes.removeIf(shape -> shape.getArea() == 0);
    }

    public static void printToConsole(ArrayList<Shape> listShapes) {
        for (Shape shape : listShapes) {
            System.out.println(shape.toString());
        }
    }

    public static void printToFile(ArrayList<Shape> listShapes, String pathFileOutput) {
        try (PrintWriter writer = new PrintWriter(pathFileOutput)) {
            for (Shape shape : listShapes) {
                writer.println(shape.toString());
            }
            MyLog.getLogger().info(String.format("The result is displayed on the file %s", pathFileOutput));
        } catch (Exception e) {
            MyLog.getLogger().error("Could not open file for writing. The result is displayed on the console");
            printToConsole(listShapes);
        }
    }
}