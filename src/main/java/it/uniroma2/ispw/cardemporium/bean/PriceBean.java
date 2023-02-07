package it.uniroma2.ispw.cardemporium.bean;

public class PriceBean {
    private Double price_bean;
    public Boolean result;

    public Double getPrice_bean() {
        return price_bean;
    }

    public void setPrice_bean(Double price_bean) {
        this.price_bean = price_bean;
    }
    public Boolean check_price_syntax(Double price_bean){
        return result;
    }
}