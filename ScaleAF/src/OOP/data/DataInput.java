package OOP.data;

public class DataInput {
    private boolean isCorrectArgs;
    private double[] inputArray;
    private String operand;
    private double result;

    public DataInput() {
        isCorrectArgs = false;
    }

    public boolean isCorrectArgs() {
        return isCorrectArgs;
    }

    public void setCorrectArgs(boolean correctArgs) {
        this.isCorrectArgs = correctArgs;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public void parseData(String inputData) {
        String[] inputParam = inputData.split(" ");
        setOperand(inputParam[0]);
        this.inputArray = new double[inputParam.length - 1];
        int correctNumCount = 0;
        for (int i = 1; i < inputParam.length; i++) {
            try {
                this.inputArray[i - 1] = Double.parseDouble(inputParam[i]);
                correctNumCount++;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат аргумента в позиции: " + i);
            }
        }
        // проверяем все аргументы на корректное значение
        if (correctNumCount == this.inputArray.length) setCorrectArgs(true);

        setResult();
    }

    private void setResult() {
        switch (getOperand()) {
            case "add":
                this.result = getAdd(this.inputArray);
                break;
            case "mul":
                result = getMul(inputArray);
                break;
            case "maa":
                try {
                    result = getMulAdd(inputArray);
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Слишком мало аргументов для данной операции");
                }

            default:
                System.out.println("Неверный формат операции");
                setCorrectArgs(false);
        }
    }

    public double getResult() {
        return result;
    }

    private double getMulAdd(double[] arr) {
        if (arr.length > 3) System.out.println("Слишком много аргументов, результат для первых трёх");
        if (arr.length < 3) throw new IndexOutOfBoundsException();
        return (arr[0] * arr[1]) + arr[2];
    }

    private double getMul(double[] arr) {
        double result = 1;
        for (double v : arr) {
            result *= v;
        }
        return result;
    }

    private double getAdd(double[] arr) {
        double result = 0;
        for (double v : arr) {
            result += v;
        }
        return result;
    }
}
