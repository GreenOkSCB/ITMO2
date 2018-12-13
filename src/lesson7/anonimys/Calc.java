package lesson7.anonimys;

import lesson7.anonimys.Operation;

public class Calc {
    double a;
    double b;

    public Calc(int a, int b){
        this.a = a;
        this.b = b;
    }

    public double summ(Operation operation){
        return operation.apply(a, b);
    }
    public double minus(Operation operation){
        return operation.apply(a, b);
    }
}
