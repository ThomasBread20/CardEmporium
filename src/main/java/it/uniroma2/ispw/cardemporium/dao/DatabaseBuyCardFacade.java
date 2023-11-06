package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class DatabaseBuyCardFacade {

    BuyCardDAO buyCardDAO;

    SearchCardDao searchCardDao;

    ShoppingCartDAO shoppingCartDAO;

    public void buyCard(int id, int user) throws ExceptionDBerror {
        buyCardDAO = new BuyCardDAO();

            buyCardDAO.buyCard(id, user);

    }

    public ObservableList<CopiaCard> searchCard(String name) throws ExceptionCardNotExist, SQLException, ExceptionDBerror {
        searchCardDao = new SearchCardDao();

            return searchCardDao.getCardList(name);

    }
    public void setCard(int id, int user) throws ExceptionDBerror {
        shoppingCartDAO = new ShoppingCartDAO();

        shoppingCartDAO.setCard(id, user);

    }

    public int getID(String username) throws ExceptionDBerror, SQLException {
        shoppingCartDAO = new ShoppingCartDAO();

        return shoppingCartDAO.getID(username);

    }

    public void detCard(int id) throws ExceptionDBerror {
        shoppingCartDAO = new ShoppingCartDAO();

        shoppingCartDAO.detCard(id);

    }

    public ObservableList<CopiaCardCarrello> getCard(int id) throws ExceptionDBerror, ExceptionCardNotExist, SQLException {
        shoppingCartDAO = new ShoppingCartDAO();

        return shoppingCartDAO.getCard(id);

    }
}
