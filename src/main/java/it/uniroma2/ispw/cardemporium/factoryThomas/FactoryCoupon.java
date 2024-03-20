package it.uniroma2.ispw.cardemporium.factoryThomas;

import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;

public class FactoryCoupon {

    enum type{
        FirstCoupon,
        NoCoupon,

        Coupon5


    }


    public CouponInterface createCoupon(String  coupon) {

        switch (coupon){
            case "NoCoupon" : return new noCoupon();
            case "FirstCoupon" : return new CouponFirst();
            case "Coupon5" : return new Coupontest();
            default: return null;
        }

    }


}

