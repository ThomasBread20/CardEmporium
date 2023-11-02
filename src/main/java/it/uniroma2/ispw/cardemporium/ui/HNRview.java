package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HNRview {

    @FXML
    private Pane Base;

    @FXML
    private Button ButtomLogin;

    @FXML
    private Button ButtomRegister;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;

    @FXML
    private Text testoCard;




    @FXML
    void Search(ActionEvent event) throws SQLException,ExceptionDBerror, ExceptionSwitchpage {
        try{
            ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard(researchBar.getText());




            FXMLLoader loader = new FXMLLoader(getClass().getResource("Schermata_cartaNR.fxml"));
            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            CardviewNR cardView = loader.getController();



            cardView.initData1(cards.get(0).getNomeCarta(), cards.get(0).getNomeGioco());
            cardView.modifytable(cards);


            window.setScene(viewRegisterScene);
            window.show();




        }catch (ExceptionCardNotExist e)
        {

            Popup.CardNoExist();

        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        }


    }


    @FXML
    public void login(ActionEvent event) throws IOException, ExceptionSwitchpage {


        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata login", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }
    }

    @FXML
    public void register(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata registrazione", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }




    }

}

