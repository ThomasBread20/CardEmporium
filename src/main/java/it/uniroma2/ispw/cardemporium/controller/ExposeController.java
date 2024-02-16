package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.bean.*;
import it.uniroma2.ispw.cardemporium.factory.MyCardBaseInterface;
import it.uniroma2.ispw.cardemporium.factory.Factory;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.ExposeDAO;
import it.uniroma2.ispw.cardemporium.dao.SearchAllCardDAO;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;


public class ExposeController {
    private MyCardBaseInterface card;

    static String ce="Card Emporium";
    public ExposeController(int type){
        Factory factory=new Factory();
        try {
            this.card=factory.createCard(type);
        } catch (CardGameException e) {
            e.getMessage();
        }

    }
    public ExposeController(){}
    
    public  ObservableList<Card> searchAllCard(CardBean cardBean) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        SearchAllCardDAO src = new SearchAllCardDAO();

        return  src.getAllCard(cardBean);


    }

    public  CopiaCard exposeOnMarketY(CardInfoBean cardInfoBean) throws Exceptionquantity   {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(cardInfoBean.getQuantity()<1){
            throw new Exceptionquantity(ex.toString());
        }

        boolean result=ex.exposeCardY(cardInfoBean, info.getID());
        card = new CopiaCard(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(ce);
            alert.setHeaderText("ERROR numero 1");
        }
        return card;
    }
    public  String getConcreteGame(String nomegioco) {
        ExposeController exposeController = null;
        if(nomegioco.equals("Yu-gi-oh")){
             exposeController=new ExposeController(1);

            
        }
        else if(nomegioco.equals("Pokemon")){
             exposeController=new ExposeController(2);
        } else if (nomegioco.equals("DragonBall")) {
            exposeController=new ExposeController(3);
        } else if (nomegioco.equals("Magic")) {
             exposeController=new ExposeController(4);
        }
        assert exposeController != null;
        return exposeController.card.useCard();

    }
    public  CopiaCard exposeOnMarketM(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();

        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(cardInfoBean.getQuantity()<1){
            throw new Exceptionquantity(ex.toString());
        }

        Boolean result = ex.exposeCardM(cardInfoBean, info.getID());
        card = new CopiaCard(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(ce);
            alert.setHeaderText("ERROR numero 2");
        }
        return card;
    }

    public  CopiaCard exposeOnMarketDB(CardInfoBean cardInfoBean) throws Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(cardInfoBean.getQuantity()<1){
            throw new Exceptionquantity(ex.toString());
        }

        Boolean result = ex.exposeCardDB(cardInfoBean, info.getID());
        card = new CopiaCard(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(ce);
            alert.setHeaderText("ERROR numero 3");
        }
        return card;
    }
    public  CopiaCard exposeOnMarketP(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(cardInfoBean.getQuantity()<1){

            throw new Exceptionquantity(ex.toString());
        }

        Boolean result = ex.exposeCardP(cardInfoBean, info.getID());
        card = new CopiaCard(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CardEmporium");
            alert.setHeaderText("ERROR");
        }
        return card;
    }




}


