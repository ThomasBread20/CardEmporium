package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.ExposeDAO;
import it.uniroma2.ispw.cardemporium.dao.SearchAllCardDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.users.Users;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;


public class ExposeController {
    public static ObservableList<Card> SearchAllCard(String name, int version, String game_name, String set_name) throws ExceptionCardNotExist, SQLException, ExceptionUserAlreadyExist {

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

}
