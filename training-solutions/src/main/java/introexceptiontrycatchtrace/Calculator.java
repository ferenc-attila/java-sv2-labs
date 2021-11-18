package introexceptiontrycatchtrace;

public class Calculator {

    private int firstNumber;
    private int secondNumber;

    public Calculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int addition() {
        return firstNumber + secondNumber;
    }

    public int subtraction() {
        return firstNumber - secondNumber;
    }

    public int multiplication() {
        return firstNumber * secondNumber;
    }

    public int division() {
        return firstNumber / secondNumber;
    }
}
