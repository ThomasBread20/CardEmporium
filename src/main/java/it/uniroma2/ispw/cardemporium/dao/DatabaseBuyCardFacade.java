package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class DatabaseBuyCardFacade {

    BuyCardDAO buyCardDAO;

    SearchCardDaoSingleton searchCardDaoSingleton;

    ShoppingCartDAOSingleton shoppingCartDAOSingleton;

    public void buyCard(int id, int user) throws ExceptionDBerror {
        buyCardDAO = new BuyCardDAO();

            buyCardDAO.buyCard(id, user);

    }

    public ObservableList<CopiaCard> searchCard(String name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {
        searchCardDaoSingleton = new SearchCardDaoSingleton();

            return searchCardDaoSingleton.getCard(name);

    }
    public void setCard(int id, int user) throws ExceptionDBerror {
        shoppingCartDAOSingleton = new ShoppingCartDAOSingleton();

        shoppingCartDAOSingleton.SetCard(id, user);

    }

    public int getID(String username) throws ExceptionDBerror, SQLException {
        shoppingCartDAOSingleton = new ShoppingCartDAOSingleton();

        return shoppingCartDAOSingleton.getID(username);

    }

    public void detCard(int id) throws ExceptionDBerror {
        shoppingCartDAOSingleton = new ShoppingCartDAOSingleton();

        shoppingCartDAOSingleton.detCard(id);

    }

    public ObservableList<CopiaCardCarrello> getCard(int id) throws ExceptionDBerror, ExceptionCardNotExist, SQLException {
        shoppingCartDAOSingleton = new ShoppingCartDAOSingleton();

        return shoppingCartDAOSingleton.getCard(id);

    }
}
