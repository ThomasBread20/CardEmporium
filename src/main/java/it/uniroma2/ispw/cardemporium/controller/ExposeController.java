package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.Factory.CardBase;
import it.uniroma2.ispw.cardemporium.Factory.Factory;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.ExposeDAO;
import it.uniroma2.ispw.cardemporium.dao.SearchAllCardDAO;
import it.uniroma2.ispw.cardemporium.exception.CardGameException;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;


public class ExposeController {
    private CardBase card;
    public ExposeController(int type){
        Factory factory=new Factory();
        try {
            this.card=factory.createCard(type);
        } catch (CardGameException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static ObservableList<Card> SearchAllCard(String name, int version, String game_name, String set_name) throws ExceptionCardNotExist, SQLException, ExceptionUserAlreadyExist, ExceptionDBerror {

        SearchAllCardDAO src = new SearchAllCardDAO();

        return  src.getAllCard(name, version, game_name, set_name);


    }

    public static CopiaCard ExposeOnMarket(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, String gioco, String set) throws ExceptionDBerror {
        DataSingleton dataSingleton = new DataSingleton();
        dataSingleton.getUsername();
        ExposeDAO ex = new ExposeDAO();
        CopiaCard card;
        try {
            Boolean result = ex.ExposeCard(price, quan, lan, cond, id, name, versione, dataSingleton.getUsername());
            card = new CopiaCard(cond, price, dataSingleton.getUsername(), id, name, gioco, lan, versione, set);
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
    public static String getConcreteGame(String nome_gioco) throws CardGameException {
        ExposeController exposeController = null;
        if(nome_gioco=="Yu-gi-oh"){
             exposeController=new ExposeController(1);
            
        }
        else if(nome_gioco=="Pokemon"){
             exposeController=new ExposeController(2);
        } else if (nome_gioco=="DragonBall") {
            exposeController=new ExposeController(3);
        } else if (nome_gioco=="Magic") {
             exposeController=new ExposeController(4);
        }
    return exposeController.card.useCard();

    }






}


