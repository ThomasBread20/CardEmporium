package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;

public class InsertCardController {


    public static void insertCardY(CardInfoBean cardInfoBean) throws Exceptionquantity {

        ExposeController.exposeOnMarketY(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanY(),cardInfoBean.getLanguage()));

    }
    public static Boolean insertCardP(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        ExposeController.exposeOnMarketP(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanP(),cardInfoBean.getLanguage()));
        return true;
    }
    public static Boolean insertCardDB(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        ExposeController.exposeOnMarketDB(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanDG(),cardInfoBean.getLanguage()));
        return true;
    }
    public static Boolean insertCardM(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        ExposeController.exposeOnMarketM(new CardInfoBean(cardInfoBean.getId(),new CardBean(cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()),cardInfoBean.getCondition(),cardInfoBean.getPrice(),cardInfoBean.getQuantity(),cardInfoBean.getExtraBeanM(),cardInfoBean.getLanguage()));
        return true;
    }
}
