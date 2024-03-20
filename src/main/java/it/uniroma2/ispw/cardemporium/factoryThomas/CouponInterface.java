package it.uniroma2.ispw.cardemporium.factoryThomas;

import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

import java.util.List;

public interface CouponInterface {
    double couponprize();

    double prize = CarrelloEntity.getInstance().getPrize();

    List<CardEntity> cardList = CarrelloEntity.getInstance().getCardIntoCart();

}
