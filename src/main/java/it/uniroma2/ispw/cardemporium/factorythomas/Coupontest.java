package it.uniroma2.ispw.cardemporium.factorythomas;



public class Coupontest implements CouponInterface  {
    @Override
    public double couponprize() {
        double prize1 = 0;
        for(int i = 0; i < CARD_INTO_CART.size(); i++)
        {
            if (CARD_INTO_CART.get(i).getNomeCarta().equals("drago bianco")){
                prize1 +=  5;

                if (prize1 > PRIZE){
                    prize1 = 0;
                }
            }
        }



        return prize1;

    }

}
