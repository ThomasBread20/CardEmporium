package it.uniroma2.ispw.cardemporium.dao.thomas;

import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.filesystemdb.ShopcardFS;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.model.CarrelloEntity;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class DatabaseBuyCardFacade {

    BuyCardDAODB buyCardDAO;

    SearchCardDao searchCardDao;

    ShoppingCartDAO shoppingCartDAO;

    ShopcardFS shopcardFS;



    public void buyCard(int id, int user) throws ExceptionDBerror {
        buyCardDAO = new BuyCardDAODB();

            buyCardDAO.buyCard(id, user);

    }

    public ObservableList<CardEntity> searchCard(String name) throws ExceptionCardNotExist, SQLException {
        searchCardDao = new SearchCardDao();

            return searchCardDao.getcardlist(name);

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

    public ObservableList<CarrelloEntity> getCard(int id) throws ExceptionDBerror, ExceptionCardNotExist, SQLException {
        shoppingCartDAO = new ShoppingCartDAO();

        return shoppingCartDAO.getCard(id);

    }
    public void addCard(CarrelloEntity value, int id){
        shopcardFS = new ShopcardFS();

        shopcardFS.addcard(value, id);

    }

}
