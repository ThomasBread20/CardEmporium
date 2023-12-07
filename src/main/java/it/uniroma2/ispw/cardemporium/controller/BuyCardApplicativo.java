package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.dao.DatabaseBuyCardFacade;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import it.uniroma2.ispw.cardemporium.ui.CardView;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

 public class BuyCardApplicativo {

     private BuyCardApplicativo() {
         throw new IllegalStateException("Utility class");
     }
    public static ObservableList<CopiaCard> searchCard(String name) throws SQLException, ExceptionCardNotExist {
        DatabaseBuyCardFacade cards = new DatabaseBuyCardFacade();
        return cards.searchCard(name);

    }
//PERCHE' TUTTE QUESTE OPERAZIONI?
    public static void addCard(int iD) throws ExceptionDBerror {
        DatabaseBuyCardFacade cards = new DatabaseBuyCardFacade();
        try{

            String nome = DataSingleton.getInstance().getUsername();
            int iDuser = cards.getID(nome);
            cards.setCard(iD, iDuser);


        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE numero 2");
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public static ObservableList<CopiaCardCarrello> searchCard1(int id) throws SQLException, ExceptionCardNotExist, ExceptionDBerror {
         DatabaseBuyCardFacade cards = new DatabaseBuyCardFacade();
        try{
            return cards.getCard(id);

        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE numero 3");
        }

    }

    public static int getID() throws ExceptionDBerror, SQLException {
        DatabaseBuyCardFacade cards = new DatabaseBuyCardFacade();
        String nome = null;
        try {

            nome = DataSingleton.getInstance().getUsername();
            return cards.getID(nome);


        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("ERRORE numero 4");
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return cards.getID(nome);
    }


    public static void removeCard(int iD) throws ExceptionDBerror {
        DatabaseBuyCardFacade cards = new DatabaseBuyCardFacade();
        try{


            cards.detCard(iD);



        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE numero 5");
        }
    }


    public static void refreshCardView(String nome, MouseEvent event, String set) throws ExceptionCardNotExist, SQLException, IOException, ExceptionSwitchpage {
        try{


           ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard( nome);



           CardView cardview = SwitchPage.switchPageDataM1("Schermata_Carta", event);

           cardview.initData1(nome, set);
           cardview.modifytable(cards);

       } catch (SQLException | ExceptionSwitchpage | IOException e) {
           e.getCause();
       } catch (ExceptionCardNotExist e) {

           CardView cardview = SwitchPage.switchPageDataM1("Schermata_Carta", event);

           cardview.initData1(nome, set);

       }
    }





}
