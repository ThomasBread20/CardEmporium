package it.uniroma2.ispw.cardemporium.factorythomas;

public class FactoryShipping {
    public CouponInterface createCoupon(String  shipping) {


        if(shipping.equals("posta4"))
        {
            return new Posta4();
        }else if(shipping.equals("posta1"))
        {
            return new Posta1();
        }

        return null;
    }
}
