package dovgopolov;

public class Animals {
    private String name;
    private String color;
    private double size;
    private int x;
    private int y;
    private int countMoves;
    private boolean hunger;
    private boolean ate;

    Animals(String name, String color, double size, int x, int y, int countMoves) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.x = x;
        this.y = y;
        this.countMoves = countMoves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = getX() + x;
        soundMove();
        countMoves--;
        hunger = true;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = getY() + y;
        soundMove();
        countMoves--;
        hunger = true;
    }

    public void getAllParameters() {
        System.out.printf("\nКличка: %s\nЦвет: %s\nРазмер: %.2f\nПоложение X: %d\nПоложение Y: %d\n", name, color, size, x, y);
    }

    public void soundMove() {
    }

    public void soundEatUp() {
        System.out.println(getName() + " ням-ням");
    }

    public void soundWhenEatMe() {
        System.out.println(getName() + " ой-ой-ой");
    }

    public int getCountMoves() {
        return countMoves;
    }

    public void setCountMoves(int countMoves) {
        this.countMoves = countMoves;
    }

    public boolean isHungry() {
        return hunger;
    }

    public void setHungry(boolean hunger) {
        this.hunger = hunger;
    }
}
