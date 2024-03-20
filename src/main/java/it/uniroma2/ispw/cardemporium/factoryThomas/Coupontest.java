package it.uniroma2.ispw.cardemporium.factoryThomas;



public class Coupontest implements CouponInterface  {
    @Override
    public double couponprize() {
        double prize1 = 0;
        for(int i = 0; i < cardList.size(); i++)
        {
            if (cardList.get(i).getNomeCarta().equals("drago bianco")){
                prize1 +=  5;

                if (prize1 > prize){
                    prize1 = 0;
                }
            }
        }



        return prize1;

    }

}
