package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.dao.SearchCardDaoSingleton;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.ui.CardView;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class BuyCardApplicativo {


    public static ObservableList<CopiaCard> searchCard(String name) throws SQLException, ExceptionCardNotExist, ExceptionDBerror {
        SearchCardDaoSingleton cards = SearchCardDaoSingleton.getInstance();
        try{
            return cards.getCard(name);

        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }

    }

    public void addCard(ObservableList<CopiaCard> card){
        //CardView.modifytable(card);
        return;
    }
}
