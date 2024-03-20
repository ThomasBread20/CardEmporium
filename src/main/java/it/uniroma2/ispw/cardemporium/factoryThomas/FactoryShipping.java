package it.uniroma2.ispw.cardemporium.factoryThomas;

import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;

public class FactoryShipping {
    public CouponInterface createCoupon(String  shipping) {

        switch (shipping){
            case "posta4" : return new Posta4();
            case "posta1" : return new Posta1();

        }

        return null;
    }
}
