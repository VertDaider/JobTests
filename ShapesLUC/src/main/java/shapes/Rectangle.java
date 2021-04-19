package shapes;

import util.MyLog;

import java.util.Objects;

public class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        if (width > 0 && length > 0) {
            this.length = length;
            this.width = width;
        } else {
            MyLog.getLogger().error("The file contains invalid data. Shape not added");
        }
    }

    public double getWidth() {
        return Math.min(width, length);
    }

    public double getLength() {
        return Math.max(width, length);
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return length * 2 + width * 2;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }

    @Override
    public String toString() {
        return String.format(
                "Тип фигуры: Прямоугольник%n" +
                "Длина: %.2f м%n" +
                "Ширина: %.2f м%n" +
                "Площадь: %.2f кв. м%n" +
                "Периметр: %.2f м%n" +
                "Длина диагонали: %.2f м%n",
                this.getLength(), this.getWidth(), this.getArea(), this.getPerimeter(), this.getDiagonal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}