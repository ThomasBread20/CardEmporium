package it.uniroma2.ispw.cardemporium.model;


import it.uniroma2.ispw.cardemporium.factorythomas.FactoryCoupon;
import it.uniroma2.ispw.cardemporium.factorythomas.FactoryShipping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartEntity {

        private static ShoppingCartEntity instance = null;

        public static ShoppingCartEntity getInstance(){
                if(instance==null){
                        instance=new ShoppingCartEntity();
                }
                return instance;
        }
        private Double prize = 0.00;


        private List<CardEntity> cardIntoCart;

        private List<String> couponList = new ArrayList<>();

        public void removeFirstfromCouponList(){
                couponList.remove("FirstCoupon");

        }


        private double totalprize = 0.00;

        private double totalprizecoupon = 0.00;


        public double getTotalprize() {
                return totalprize;
        }

        public double getTotalprizecoupon() {
                return totalprizecoupon;
        }




        public void setPrizeCoupon(Coupon coupon) {

                this.totalprizecoupon = totalprize;


                FactoryCoupon prizefacotry = new FactoryCoupon();

                this.totalprizecoupon = totalprize - prizefacotry.createCoupon(coupon).couponprize();

        }

        public void setPrizeShipping(Shipping shipping) {

                this.totalprize = prize;


                FactoryShipping factoryShipping = new FactoryShipping();

                this.totalprize = prize + factoryShipping.createCoupon(shipping).couponprize();

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

        public List<CardEntity> getCardIntoCart() {
                return cardIntoCart;
        }

        public void clearCarrello(){
                cardIntoCart.clear();
        }
}
