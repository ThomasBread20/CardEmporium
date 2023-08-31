package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.dao.SearchAllCardDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.model.Card;

import java.sql.SQLException;
import java.util.List;

public class ExposeController {
    public static Card SearchAllCard(String name, int version, String game_name, String set_name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror, ExceptionUserAlreadyExist {
        SearchAllCardDAO src = new SearchAllCardDAO();
        return src.getAllCard(name, version, game_name, set_name);


    }
}
