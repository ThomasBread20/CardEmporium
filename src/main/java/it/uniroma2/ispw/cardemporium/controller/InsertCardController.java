package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;

public class InsertCardController {
    public InsertCardController() {
        //constructor
    }
    ExposeController exposeController;
    public void insertCardY(CardInfoBean cardInfoBean) throws Exceptionquantity {

        exposeController.exposeOnMarketY(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanY(),cardInfoBean.getLanguage()));

    }
    public  Boolean insertCardP(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        exposeController.exposeOnMarketP(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanP(),cardInfoBean.getLanguage()));
        return true;
    }
    public  Boolean insertCardDB(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        exposeController.exposeOnMarketDB(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanDG(),cardInfoBean.getLanguage()));
        return true;
    }
    public  Boolean insertCardM(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        exposeController.exposeOnMarketM(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanM(),cardInfoBean.getLanguage()));
        return true;
    }
}
