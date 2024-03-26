package it.uniroma2.ispw.cardemporium.factorythomas;


import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

import java.util.List;

public class Coupontest implements CouponInterface  {
    @Override
    public double couponprize() {

        double prize = CarrelloEntity.getInstance().getPrize();

        List<CardEntity> cardIntoCart = CarrelloEntity.getInstance().getCardIntoCart();
        double prize1 = 0;
        for(int i = 0; i < cardIntoCart.size(); i++)
        {
            if (cardIntoCart.get(i).getNomeCarta().equals("drago bianco")){
                prize1 +=  5;

                if (prize1 > prize){
                    prize1 = 0;
                }
            }
        }



        return prize1;

    }

}
