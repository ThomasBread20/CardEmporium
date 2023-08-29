package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.dao.SearchCardDaoSingleton;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;

import java.sql.SQLException;
import java.util.ArrayList;

public class BuyCardApplicativo {


    public static ArrayList<CopiaCard> searchCard(String name) throws SQLException, ExceptionCardNotExist, ExceptionDBerror {
        SearchCardDaoSingleton cards = SearchCardDaoSingleton.getInstance();
        try{
            return cards.getCard(name);

        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }



    }
}
