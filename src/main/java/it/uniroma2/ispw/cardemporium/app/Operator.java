package it.uniroma2.ispw.cardemporium.app;

public class Operator implements MathOp {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
