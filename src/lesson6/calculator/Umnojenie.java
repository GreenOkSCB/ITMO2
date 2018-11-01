package lesson6.calculator;

public class Umnojenie implements Operation {
    public Umnojenie(int a, int b) {
    }

    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
