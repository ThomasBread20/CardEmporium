package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.InitProfileButton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;


public class Seller2view {
    @FXML
    private Button sellCard;

        @FXML
        private TextField Price;

        @FXML
        private Button cardName;

        @FXML
        private Button logoutButton;

        @FXML
        private TextField number;

        @FXML
        private Text profiloButton;

        @FXML
        private TextField searchProduct;

        @FXML
        private TextArea textArea;


        @FXML
        void cardName(ActionEvent event) {

        }

        @FXML
        void logout(ActionEvent event) throws ExceptionSwitchpage {
            LogoutAction.logout(event);
        }

        @FXML
        void number(ActionEvent event) {

        }

        @FXML
        void price(ActionEvent event) {

        }




        @FXML
        void search(ActionEvent event) {

        }
    @FXML
    void sell(ActionEvent event) {

    }

    public void profiloButton(ActionEvent event) throws IOException {
        InitProfileButton.InitProfileUser(event);
    }
}


