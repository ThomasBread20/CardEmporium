package it.uniroma2.ispw.cardemporium.factoryThomas;




public class CouponFirst implements CouponInterface{
    @Override
    public double couponprize() {
        double sale = 0.0;
        sale = (5*prize)/100.0;
        if(sale > prize){
            sale = 0;
        }
        return sale;
    }

}
