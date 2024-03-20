package it.uniroma2.ispw.cardemporium.bean.thomas;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CouponInformationBean {

    private String prize;

    private String type = "NoCoupon";

    private String shipping;

    public void setShipping(String shipping) {

        if(shipping == null)
        {
            this.type = "NoShippin";
        }else{
            this.shipping = shipping;
        }

    }

    public String getShipping() {
        return shipping;
    }

    public void couponinformationbean1(String prize, String type) {
        this.prize = prize;
        this.type = type;
    }

    public String getPrize() {
        return prize;
    }

    public String getType() {
        return type;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public void setType(String type) {
        if(type == null)
        {
            this.type = "NoCoupon";
        }else{
            this.type = type;
        }


    }

    public List<String > translateObserveIntoList(ObservableList<String > cards)
    {
        List<String> listaCarte = new ArrayList<>();
        for(int value = 0; value < cards.size(); value++){
            listaCarte.add(cards.get(value));
        }
        return listaCarte;
    }

    public ObservableList<String> translateListINtoObserve(List<String> cards)
    {
        ObservableList<String> listaCarte = FXCollections.observableArrayList();
        for(int value = 0; value < cards.size(); value++){
            listaCarte.add(cards.get(value));
        }
        return listaCarte;
    }

}
