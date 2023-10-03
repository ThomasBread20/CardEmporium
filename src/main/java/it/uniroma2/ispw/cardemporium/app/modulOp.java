package it.uniroma2.ispw.cardemporium.app;

public class modulOp implements MathOp {

    int mod;
    public modulOp(int mod) {
        this.mod = mod;
    }

    @Override
    public int sum(int a, int b) {
        return a + b % mod;
    }

    @Override
    public int minus(int a, int b) {
        return a - b % mod;
    }
}
