package it.uniroma2.ispw.cardemporium.factorythomas;

public class FactoryCoupon {



    public CouponInterface createCoupon(String  coupon) {

        switch (coupon){
            case "NoCoupon" : return new NoCoupon();
            case "FirstCoupon" : return new CouponFirst();
            case "Coupon5" : return new Coupontest();
            default: return null;
        }

    }


}

