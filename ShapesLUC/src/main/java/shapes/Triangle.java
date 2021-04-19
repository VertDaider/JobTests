package shapes;

import util.MyLog;

import java.util.Objects;

public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && isExistTriangle(a, b, c)) {
            this.a = Math.max(Math.max(a, b), c);
            this.b = Math.min(Math.min(a, b), c);
            this.c = (a + b + c) - this.a - this.b;
        } else {
            MyLog.getLogger().error("The file contains invalid data. Shape not added");
        }
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    // проверка невырожденности треугольника
    private boolean isExistTriangle(double a, double b, double c) {
        return a + b > c && b + c > a && a + c > b;
    }

    private double getAngle(double a, double b, double c) {
        return Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
    }

    @Override
    public String toString() {
        return String.format(
                "Тип фигуры: Треугольник%n" +
                        "Сторона 1: %.2f м, противолежащий угол: %.2f%n" +
                        "Сторона 2: %.2f м, противолежащий угол: %.2f%n" +
                        "Сторона 3: %.2f м, противолежащий угол: %.2f%n" +
                        "Площадь: %.2f кв. м%n" +
                        "Периметр: %.2f м%n",
                c, getAngle(a,b,c), a, getAngle(b,c,a), b, getAngle(a,c,b), this.getArea(), this.getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.a, a) == 0 && Double.compare(triangle.b, b) == 0 && Double.compare(triangle.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}