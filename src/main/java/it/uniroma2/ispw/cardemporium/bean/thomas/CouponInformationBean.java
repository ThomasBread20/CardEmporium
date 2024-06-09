package it.uniroma2.ispw.cardemporium.bean.thomas;


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

}
