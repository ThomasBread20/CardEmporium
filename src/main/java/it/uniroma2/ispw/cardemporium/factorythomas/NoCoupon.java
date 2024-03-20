package it.uniroma2.ispw.cardemporium.factorythomas;

public class NoCoupon implements CouponInterface {


    @Override
    public double couponprize() {
        return 0.0;
    }
}
