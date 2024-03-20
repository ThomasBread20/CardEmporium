package it.uniroma2.ispw.cardemporium.factorythomas;




public class CouponFirst implements CouponInterface{
    @Override
    public double couponprize() {
        double sale;
        sale = (5* PRIZE)/100.0;
        if(sale > PRIZE){
            sale = 0;
        }
        return sale;
    }

}
