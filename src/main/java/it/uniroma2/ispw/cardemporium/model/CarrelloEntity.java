package it.uniroma2.ispw.cardemporium.model;


import it.uniroma2.ispw.cardemporium.factoryThomas.FactoryCoupon;
import it.uniroma2.ispw.cardemporium.factoryThomas.FactoryShipping;

import java.util.ArrayList;
import java.util.List;

public class CarrelloEntity {

        private static CarrelloEntity instance = null;

        public static CarrelloEntity getInstance(){
                if(instance==null){
                        instance=new CarrelloEntity();
                }
                return instance;
        }
        private Double prize = 0.00;

        private CarrelloEntity carrello;

        private List<CardEntity> cardIntoCart;

        private List<String> couponList = new ArrayList<String>();

        public void removeFirstfromCouponList(){
                couponList.remove("FirstCoupon");

        }

        private FactoryCoupon prizeCoupon;

        private double totalprize = 0.00;

        private double totalprizecoupon = 0.00;


        public double getTotalprize() {
                return totalprize;
        }

        public double getTotalprizecoupon() {
                return totalprizecoupon;
        }




        public void setPrizeCoupon(String tipo) {

                this.totalprizecoupon = totalprize;


                FactoryCoupon prizefacotry = new FactoryCoupon();

                this.totalprizecoupon = totalprize - prizefacotry.createCoupon(tipo).couponprize();

        }

        public void setPrizeShipping(String tipo) {

                this.totalprize = prize;


                FactoryShipping prizefacotry = new FactoryShipping();

                this.totalprize = prize + prizefacotry.createCoupon(tipo).couponprize();

        }




        public void setCouponList(List<String> coupon) {
                this.couponList = coupon;
        }


        public List<String> getCouponList() {
                return couponList;
        }

        public void setPrize() {

                for(int i = 0; i < cardIntoCart.size();i++){
                        prize += cardIntoCart.get(i).getPrezzo();
                }
        }
        public void resetPrize(){
                prize = 0.00;
        }
        public void addPrize(double value){
                prize = prize + value;
        }

        public void removePrize(double value){
                prize = prize - value;
        }

        public void setCardIntoCart(List<CardEntity> cardIntoCart) {
                this.cardIntoCart = cardIntoCart;
        }

        public Double getPrize() {

                return prize;
        }

        public Double getCouponPrize(){

                return prize;
        }

        public List<CardEntity> getCardIntoCart() {
                return cardIntoCart;
        }

        public void clearCarrello(){
                cardIntoCart.clear();
        }
}
