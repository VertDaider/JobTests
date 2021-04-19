package dovgopolov;

public class Flying extends Animals {

    public Flying(String name, String color, double size, int x, int y, int countMoves) {
        super(name, color, size, x, y, countMoves);
    }

    @Override
    public void soundMove() {
        System.out.println(getName() + " кар-кар");
    }
}
