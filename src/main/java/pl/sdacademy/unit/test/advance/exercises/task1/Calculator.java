package pl.sdacademy.unit.test.advance.exercises.task1;

public class Calculator {

    public int multiply(int firstDigit, int secondDigit) {
        return firstDigit * secondDigit;
    }

    public int divide(int firstDigit, int secondDigit) {
        if(secondDigit == 0) {
            throw new IllegalArgumentException("Can't divide by 0!");
        }
        return firstDigit/secondDigit;
    }
}
