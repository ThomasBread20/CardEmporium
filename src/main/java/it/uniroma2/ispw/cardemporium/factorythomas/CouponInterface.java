package it.uniroma2.ispw.cardemporium.factorythomas;

import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;

import java.util.List;


public interface CouponInterface {
    double couponprize();

    double PRIZE = CarrelloEntity.getInstance().getPrize();

    List<CardEntity> CARD_INTO_CART = CarrelloEntity.getInstance().getCardIntoCart();



}
