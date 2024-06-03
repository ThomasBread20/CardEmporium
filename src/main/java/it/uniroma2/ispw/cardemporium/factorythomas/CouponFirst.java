package it.uniroma2.ispw.cardemporium.factorythomas;



import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;


public class CouponFirst implements CouponInterface{




    @Override
    public double couponprize() {

        double prize = CarrelloEntity.getInstance().getPrize();


        double sale;
        sale = (5* prize)/100.0;
        if(sale > prize){
            sale = 0;
        }
        return sale;
    }

}
