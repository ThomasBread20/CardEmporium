package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.Factory.CardBase;
import it.uniroma2.ispw.cardemporium.Factory.Factory;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanDG;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanM;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanP;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanY;
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
    private CardBase card;
    String ex="no cards";
    static String ce="Card Emporium";
    public ExposeController(int type){
        Factory factory=new Factory();
        try {
            this.card=factory.createCard(type);
        } catch (CardGameException e) {
            e.printStackTrace();
        }

    }
    
    public static ObservableList<Card> SearchAllCard(String name, int version, String game_name, String set_name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {

        SearchAllCardDAO src = new SearchAllCardDAO();

        return  src.getAllCard(name, version, game_name, set_name);


    }

    public static CopiaCard ExposeOnMarketY(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, String gioco, ExtraBeanY extraBeanY, String set) throws ExceptionDBerror, Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(quan<1){
            throw new Exceptionquantity(ex.toString());
        }
        try {

            Boolean result = ex.ExposeCardY(price, quan, lan, cond, id, name, versione,extraBeanY, info.getID());
            System.out.println(info.getUsername());
            card = new CopiaCard(cond, price, info.getUsername(), id, name, gioco, lan, versione, set,quan);
            if (result != true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(ce);
                alert.setHeaderText("ERROR numero 1");
            }
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("ERRORE numero 1.1");
        }
        return card;
    }
    public static String getConcreteGame(String nome_gioco) {
        ExposeController exposeController = null;
        if(nome_gioco.equals("Yu-gi-oh")){
             exposeController=new ExposeController(1);

            
        }
        else if(nome_gioco.equals("Pokemon")){
             exposeController=new ExposeController(2);
        } else if (nome_gioco.equals("DragonBall")) {
            exposeController=new ExposeController(3);
        } else if (nome_gioco.equals("Magic")) {
             exposeController=new ExposeController(4);
        }
    return exposeController.card.useCard();

    }
    public static CopiaCard ExposeOnMarketM(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, String gioco, ExtraBeanM extraBeanM, String set) throws ExceptionDBerror, Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();

        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(quan<1){
            throw new Exceptionquantity(ex.toString());
        }
        try {

            Boolean result = ex.ExposeCardM(price, quan, lan, cond, id, name, versione,extraBeanM, info.getID());
            card = new CopiaCard(cond, price, info.getUsername(), id, name, gioco, lan, versione, set,quan);
            if (result != true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(ce);
                alert.setHeaderText("ERROR numero 2");
            }
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("ERRORE numero 2.1");
        }
        return card;
    }

    public static CopiaCard ExposeOnMarketDB(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, String gioco, ExtraBeanDG extraBeanDG, String set) throws ExceptionDBerror, Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(quan<1){
            throw new Exceptionquantity(ex.toString());
        }
        try {

            Boolean result = ex.ExposeCardDB(price, quan, lan, cond, id, name, versione,extraBeanDG, info.getID());
            card = new CopiaCard(cond, price, info.getUsername(), id, name, gioco, lan, versione, set,quan);
            if (result != true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(ce);
                alert.setHeaderText("ERROR numero 3");
            }
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("ERRORE numero 3.1");
        }
        return card;
    }
    public static CopiaCard ExposeOnMarketP(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, String gioco, ExtraBeanP extraBeanP, String set) throws ExceptionDBerror, Exceptionquantity {
        DataSingleton info = DataSingleton.getInstance();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        if(quan<1){
            throw new Exceptionquantity(ex.toString());
        }
        try {

            Boolean result = ex.ExposeCardP(price, quan, lan, cond, id, name, versione,extraBeanP, info.getID());
            card = new CopiaCard(cond, price, info.getUsername(), id, name, gioco, lan, versione, set,quan);
            if (result != true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CardEmporium");
                alert.setHeaderText("ERROR");
            }
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("ERRORE");
        }
        return card;
    }




}


