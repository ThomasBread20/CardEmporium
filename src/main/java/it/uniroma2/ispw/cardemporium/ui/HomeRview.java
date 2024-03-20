package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.thomas.CardController;
import it.uniroma2.ispw.cardemporium.controller.thomas.ShoppingController;
import it.uniroma2.ispw.cardemporium.exception.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;


import javafx.stage.Stage;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class HomeRview {






    @FXML
    private Button logoutButton;

    @FXML
    private Button sellButton;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;
    @FXML
    private Button carrello;

    @FXML
    void openCarrello(ActionEvent event) throws  ExceptionSwitchpage, ExceptionDBerror {
        CardInformationBean bean = new CardInformationBean();
        try{

            ShoppingController carta =  new ShoppingController();

            bean.setLista(carta.getListofcardIntoShoppingCart());
            SwitchPageContr.getInstance().switchCarrelo(bean);


        }catch (ExceptionCardNotExist | IOException e) {

            throw new ExceptionSwitchpage("switch page Carrello");


        }catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("DBerror");


        } catch (SQLException e) {
            e.getErrorCode();
        }
    }



    @FXML
    void searchCard(ActionEvent event) throws SQLException, ExceptionSwitchpage {

        CardController view = new CardController();
        CardInformationBean bean = new CardInformationBean();
        try{
            bean.setNomeCarta(researchBar.getText());
            List<CardInformationBean> listCard = view.searchCard(bean);
            bean.setLista(listCard);
            SwitchPageContr.getInstance().switchCardView(bean);
        }catch (ExceptionCardNotExist e)
        {
            Popup.cardNoExist();
        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }

    }







    Stage stage;

    DataSingleton info = DataSingleton.getInstance();



    @FXML
    void logout(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout();
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {
        //profile buttom
    }

    @FXML
    void sellCard(ActionEvent event) throws  ExceptionSwitchpage {
    //parte di simone

        String role = info.getRole();

        Popup.notSeller(event, role);


    }



}
