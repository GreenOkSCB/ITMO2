package lesson6.calculator;

public class Plus implements Operation {
    public Plus(int a, int b) {
    }

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
