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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfiloAdminview {



    @FXML
    private Label nome;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

    @FXML
    private Label ruolo;

    @FXML
    private Label username;

    DataSingleton info = DataSingleton.getInstance();

    public void initData(String user, String name, String surname, String born, String role) {

        username.setText(user);
        nome.setText(name);
        cognome.setText(surname);
        datanascita.setText(born);
        ruolo.setText(role);
    }

    @FXML
    void logout(ActionEvent event) throws  ExceptionSwitchpage {

        LogoutAction.logout(event);

    }
    @FXML

    public void homeButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_home_admin.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(viewRegisterScene);
        window.show();

    }

    public void profileButton(ActionEvent event) throws IOException {

        InitProfileButton.InitProfileAdmin(event);
    }
}