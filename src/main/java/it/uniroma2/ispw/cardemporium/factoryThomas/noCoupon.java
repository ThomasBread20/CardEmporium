package it.uniroma2.ispw.cardemporium.factoryThomas;

import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

public class noCoupon implements CouponInterface {


    @Override
    public double couponprize() {
        return 0.0;
    }
}
