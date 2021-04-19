package dovgopolov;

public class Walking extends Animals {
    private int countClaws;
    private int lengthClaws;

    public Walking(String name, String color, double size, int x, int y, int countMoves, int countClaws, int lenghtClaws) {
        super(name, color, size, x, y, countMoves);
        this.countClaws = countClaws;
        this.lengthClaws = lenghtClaws;
    }

    public int getCountClaws() {
        return countClaws;
    }

    public void setCountClaws(int countClaws) {
        this.countClaws = countClaws;
    }

    public int getLengthClaws() {
        return lengthClaws;
    }

    public void setLengthClaws(int lengthClaws) {
        this.lengthClaws = lengthClaws;
    }

    public void getAllParameters() {
        super.getAllParameters();
        System.out.printf("Количество когтей: %d\nДлина когтей: %d\n", countClaws, lengthClaws);
    }

    @Override
    public void soundMove() {
        System.out.println(getName() + " топ-топ");
    }
}
