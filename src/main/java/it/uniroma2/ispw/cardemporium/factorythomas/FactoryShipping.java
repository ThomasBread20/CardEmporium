package it.uniroma2.ispw.cardemporium.factorythomas;

import it.uniroma2.ispw.cardemporium.model.Shipping;

public class FactoryShipping {
    public CouponInterface createCoupon(Shipping shipping) {

        switch (shipping) {
            case POSTA_1:
                return new Posta1();
            case POSTA_4:
                return new Posta4();
            default:
                return null;
        }
    }
}
