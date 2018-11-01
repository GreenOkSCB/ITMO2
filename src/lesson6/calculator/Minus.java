package lesson6.calculator;

public class Minus implements Operation {
    public Minus(int a, int b) {
    }

    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
