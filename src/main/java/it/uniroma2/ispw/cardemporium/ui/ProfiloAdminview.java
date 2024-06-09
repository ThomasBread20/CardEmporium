package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.utility.DataSingleton;
import it.uniroma2.ispw.cardemporium.utility.LogoutAction;
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
    void logout() throws ExceptionSwitchpage {


        LogoutAction.logout();
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfiloAdmin.fxml"));
        Parent viewregister = loader.load();
        Scene viewregisterscene = new Scene(viewregister);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ProfiloAdminview profiloadminview = loader.getController();
        profiloadminview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(viewregisterscene);
        window.show();
    }
}