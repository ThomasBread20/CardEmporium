package it.uniroma2.ispw.cardemporium.model;


import java.util.List;

public class CarrelloEntity {


        private int prize;

        private List<CardEntity> cardIntoCart;


        public void setPrize(int prize) {
                this.prize = prize;
        }

        public void setCardIntoCart(List<CardEntity> cardIntoCart) {
                this.cardIntoCart = cardIntoCart;
        }

        public int getPrize() {
                return prize;
        }

        public List<CardEntity> getCardIntoCart() {
                return cardIntoCart;
        }
}
