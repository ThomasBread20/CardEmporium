package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.ShoppingCartDAOSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.dao.SearchCardDaoSingleton;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import it.uniroma2.ispw.cardemporium.ui.CardView;
import it.uniroma2.ispw.cardemporium.ui.Carrelloview;
import it.uniroma2.ispw.cardemporium.users.Users;
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

    public static void addCard(int ID) throws ExceptionDBerror {
        ShoppingCartDAOSingleton cards =  ShoppingCartDAOSingleton.getInstance();
        try{

            String nome = DataSingleton.getInstance().getUsername();
            int IDuser = cards.getID(nome);
            cards.SetCard(ID, IDuser);


        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<CopiaCardCarrello> searchCard1(int id) throws SQLException, ExceptionCardNotExist, ExceptionDBerror {
        ShoppingCartDAOSingleton cards = ShoppingCartDAOSingleton.getInstance();
        try{
            return cards.getCard(id);

        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }

    }

    public static int getID() throws ExceptionDBerror {
        ShoppingCartDAOSingleton cards =  ShoppingCartDAOSingleton.getInstance();
        try{

            String nome = DataSingleton.getInstance().getUsername();
            return cards.getID(nome);



        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void removeCard(int ID) throws ExceptionDBerror {
        ShoppingCartDAOSingleton cards =  ShoppingCartDAOSingleton.getInstance();
        try{

            String nome = DataSingleton.getInstance().getUsername();
            cards.detCard(ID);



        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }
    }





}
