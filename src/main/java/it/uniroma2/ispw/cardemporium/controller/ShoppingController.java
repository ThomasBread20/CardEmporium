package it.uniroma2.ispw.cardemporium.controller;

import it.uniroma2.ispw.cardemporium.dao.DatabaseBuyCardFacade;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import it.uniroma2.ispw.cardemporium.ui.Carrelloview;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public class ShoppingController {

    public ShoppingController() {
        throw new IllegalStateException("Utility class");
    }
    public static void shopping(int id, int user) throws ExceptionDBerror {
        DatabaseBuyCardFacade shop = new DatabaseBuyCardFacade();
        try{
            shop.buyCard(id, user);


        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        }
    }

    public void shoppingFS(CopiaCardCarrello value)  {
        DatabaseBuyCardFacade shop = new DatabaseBuyCardFacade();

            shop.addCard(value, value.getCartaID());



    }



    public void refreshCartView(ActionEvent event) throws ExceptionCardNotExist, SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage {


        try{
            BuyCardApplicativo card = new BuyCardApplicativo();

            ObservableList<CopiaCardCarrello> cards =  card.searchCard1( card.getID());
            Carrelloview carrelloview = SwitchPage.switchPageData1("Schermata_Carrello", event);


            carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror | SQLException e) {
            throw new ExceptionDBerror("value");


        }
    }
}
