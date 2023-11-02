package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.ManageCardDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import it.uniroma2.ispw.cardemporium.model.CopiaCard;

import javafx.collections.ObservableList;



import java.sql.SQLException;

public class ManageControllerApp {
    static DataSingleton info = DataSingleton.getInstance();
    public static ObservableList<CopiaCard> showCards() {

        Integer id = info.getID();
        System.out.println(id);
        ManageCardDAO manageCardDAO = new ManageCardDAO();
        ObservableList<CopiaCard> cards = null;

        try {


            cards = manageCardDAO.getCards(id);

        } catch (SQLException e) {
            e.getErrorCode();
        } catch (ExceptionCardNotExist | ExceptionDBerror e) {
            e.getCause();
        }

        return cards;

    }
}
