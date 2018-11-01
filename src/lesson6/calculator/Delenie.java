package lesson6.calculator;

public class Delenie implements Operation {
    public Delenie(int a, int b) {
    }

    @Override
    public int execute(int a, int b) {
        int c = 0;
        if (b != 0){
           c = a / b;
        }else {
            System.out.println("На ноль делить нельзя!");
        }
        return c;
        }
    }


