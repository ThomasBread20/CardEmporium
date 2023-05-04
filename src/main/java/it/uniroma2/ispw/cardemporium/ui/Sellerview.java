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

public class Sellerview {
    @FXML
    private Button Expose;


    @FXML
    private Button homeRegistrat;

    @FXML
    private Button logoutButton;

    @FXML
    private Button profileButton;


    DataSingleton info = DataSingleton.getInstance();
    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    @FXML
    public void homeRegistrato(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }


    }




    public void profileButton(ActionEvent event) throws IOException {
        InitProfileButton.InitProfileUser(event);
    }
    @FXML
    void Expose(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("Schermata venditore vendi carte seleziona carta, selezione", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page seller 2");
        }

    }

    public void manage(ActionEvent event) {

    }
}
