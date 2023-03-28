package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;


import java.io.IOException;

public class Profiloview {

    @FXML
    private Button homeButtom;

    @FXML
    private Button logoutButton;

    @FXML
    private Label nome;

    @FXML
    private Button sellButton;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

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
    void sell(ActionEvent event) throws  ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);


    }

    @FXML
    void logout(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    public void sitename1(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

        }

}


