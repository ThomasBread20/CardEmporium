package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.ManageCardDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.ui.ManageCardsView;
import it.uniroma2.ispw.cardemporium.ui.Sellerview;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public class ManageControllerApp {
    static DataSingleton info = DataSingleton.getInstance();
    public static ObservableList<CopiaCard> showCards(ActionEvent actionEvent) {
       // SwitchPage page = SwitchPage.getInstance();
        Integer id = info.getID();
        System.out.println(id);
        ManageCardDAO manageCardDAO = new ManageCardDAO();
        ObservableList<CopiaCard> cards = null;
      //  ManageCardsView sellerview;
        try {
          //  sellerview = page.switchPageMC("schermata_venditore_Visualizza_vendite", actionEvent);

            cards = manageCardDAO.getCards(id);
           // sellerview.modify_table(cards);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ExceptionCardNotExist e) {
            throw new RuntimeException(e);
        } catch (ExceptionDBerror e) {
            throw new RuntimeException(e);
        }

        return cards;

    }
}
