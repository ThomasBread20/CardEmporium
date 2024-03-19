package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.bean.UserBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.simone.ManageCardDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;

import it.uniroma2.ispw.cardemporium.model.CardEntity;

import it.uniroma2.ispw.cardemporium.model.simone.CardEntitySImo;
import javafx.collections.ObservableList;



import java.sql.SQLException;

public class ManageControllerApp {


        public ManageControllerApp() {
            //constructor
        }
    static DataSingleton info = DataSingleton.getInstance();
    public ObservableList<CardEntitySImo> showCards() {
        UserBean userBean=new UserBean(info.getID());

        ManageCardDAO manageCardDAO = new ManageCardDAO();
        ObservableList<CardEntitySImo> cards = null;

        try {


            cards = manageCardDAO.getCards(userBean);

        } catch (SQLException e) {
            e.getErrorCode();
        } catch (ExceptionCardNotExist e) {
            e.getCause();
        }

        return cards;

    }
}
