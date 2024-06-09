package it.uniroma2.ispw.cardemporium.controller.simone;

import it.uniroma2.ispw.cardemporium.bean.simone.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.simone.CardBean;
import it.uniroma2.ispw.cardemporium.utility.DBconstants;
import it.uniroma2.ispw.cardemporium.factorysimone.MyCardBaseInterface;
import it.uniroma2.ispw.cardemporium.factorysimone.Factory;
import it.uniroma2.ispw.cardemporium.utility.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.simone.ExposeDAO;
import it.uniroma2.ispw.cardemporium.dao.simone.SearchAllCardDAO;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.model.simone.Card;
import it.uniroma2.ispw.cardemporium.model.simone.CardEntitySImo;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;


public class ExposeController {
    private MyCardBaseInterface card;


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

    public CardEntitySImo exposeOnMarketY(CardInfoBean cardInfoBean) throws Exceptionquantity   {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();

        if(cardInfoBean.getQuantity()<1){
            throw new Exceptionquantity(ex.toString());
        }

        boolean result=ex.exposeCardY(cardInfoBean, info.getID());
        CardEntitySImo c = new CardEntitySImo(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(DBconstants.NAME);
            alert.setHeaderText("ERROR numero 1");
        }
        return c;
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
    public CardEntitySImo exposeOnMarketM(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();

        ExposeDAO ex = new ExposeDAO();
        CardEntitySImo ca;
        if(cardInfoBean.getQuantity()<1){
            throw new Exceptionquantity(ex.toString());
        }
        Boolean result = ex.exposeCardM(cardInfoBean, info.getID());


        ca = new CardEntitySImo(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(DBconstants.NAME);
            alert.setHeaderText("ERROR numero 2");
        }
        return ca;
    }

    public CardEntitySImo exposeOnMarketDB(CardInfoBean cardInfoBean) throws Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CardEntitySImo c;
        if(cardInfoBean.getQuantity()<1){
            throw new Exceptionquantity(ex.toString());
        }

        Boolean result = ex.exposeCardDB(cardInfoBean, info.getID());
        c= new CardEntitySImo(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(DBconstants.NAME);
            alert.setHeaderText("ERROR numero 3");
        }
        return c;
    }
    public CardEntitySImo exposeOnMarketP(CardInfoBean cardInfoBean) throws  Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CardEntitySImo ca;
        if(cardInfoBean.getQuantity()<1){

            throw new Exceptionquantity(ex.toString());
        }

        Boolean result = ex.exposeCardP(cardInfoBean, info.getID());
        ca = new CardEntitySImo(cardInfoBean.getCondition(),cardInfoBean.getPrice(), info.getUsername(), cardInfoBean.getLanguage(),new Card(cardInfoBean.getId(),cardInfoBean.getNome(),cardInfoBean.getVersione(),cardInfoBean.getGioco(),cardInfoBean.getSet()), cardInfoBean.getQuantity());
        if (Boolean.FALSE.equals(result)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(DBconstants.NAME);
            alert.setHeaderText("ERROR");
        }
        return ca;
    }




}


