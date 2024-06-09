package it.uniroma2.ispw.cardemporium.model;

public enum Coupon {
    NO_COUPON,
    FIRST_COUPON,
    COUPON_5;

    public static Coupon fromString(String couponName) throws IllegalArgumentException {
        switch (couponName) {
            case "NoCoupon":
                return NO_COUPON;
            case "FirstCoupon":
                return FIRST_COUPON;
            case "Coupon5":
                return COUPON_5;
            default:
                throw new IllegalArgumentException("invalid coupon name");
        }
    }

}
