package lesson7.anonimys;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc(3, 1);
        calc.summ(new Operation() {
            @Override
            public double apply(double var1, double var2) {
                return var1 + var2;
            }
        });
        calc.minus(new Operation() {
            @Override
            public double apply(double var1, double var2) {
                return var1 - var2;
            }
        });
        Calc calc1 = new Calc(3,90);
        calc1.summ(new Operation() {
            @Override
            public double apply(double var1, double var2) {
                return var1 * var2;
            }
        });


    }
}
