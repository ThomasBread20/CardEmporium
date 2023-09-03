package it.uniroma2.ispw.cardemporium.bean;

public class CardInfoBean {
    private String condition;
    private Float price;
    private Integer quantity;
    private String language;

    public CardInfoBean(String condition, Float price, Integer quantity, String language) {
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.language = language;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



}
