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
import javafx.stage.Stage;

import java.io.IOException;


public class Forsalecardview {

    @FXML
    private Button logoutBut;

    @FXML
    private Button profileBut;

    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);
    }
    DataSingleton info = DataSingleton.getInstance();


    @FXML
    void profile(ActionEvent event) throws IOException {
        InitProfileButton.InitProfileUser(event);
    }

}
