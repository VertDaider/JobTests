package shapes;

import util.MyLog;

import java.util.Objects;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            MyLog.getLogger().error("The file contains invalid data. Shape not added");
        }
    }

    public double getDiameter() {
        return this.radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return String.format(
                "Тип фигуры: Круг%n" +
                        "Радиус: %.2f м%n" +
                        "Диаметр: %.2f м%n" +
                        "Площадь: %.2f кв. м%n" +
                        "Длина окружности: %.2f м%n",
                radius, this.getDiameter(), this.getArea(), this.getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}