package dovgopolov;

public class Waterfowl extends Animals {

    public Waterfowl(String name, String color, double size, int x, int y, int countMoves) {
        super(name, color, size, x, y, countMoves);
    }

    @Override
    public void soundMove() {
        System.out.println(getName() + " буль-буль");
    }

    @Override
    public void soundWhenEatMe() {
        System.out.println(getName() + " буль-буль-буль-буль");
    }
}
