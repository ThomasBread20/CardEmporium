package it.uniroma2.ispw.cardemporium.app;

public class wtf {

    MathOp op;
    int a;
    int b;

    public wtf(MathOp op, int a, int b) {
        this.op = op;
        this.a = a;
        this.b = b;
    }

    public int doSum() {
        return op.sum(a, b);
    }
}
