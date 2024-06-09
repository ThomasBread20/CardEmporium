package it.uniroma2.ispw.cardemporium.factorythomas;

import it.uniroma2.ispw.cardemporium.model.Coupon;

public class FactoryCoupon {



    public CouponInterface createCoupon(Coupon coupon) {

        switch (coupon){
            case NO_COUPON: return new NoCoupon();
            case FIRST_COUPON: return new CouponFirst();
            case COUPON_5: return new Coupontest();
            default: return null;
        }

    }


}

