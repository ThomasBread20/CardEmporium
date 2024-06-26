package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.utility.DataSingleton;
import it.uniroma2.ispw.cardemporium.utility.LogoutAction;
import it.uniroma2.ispw.cardemporium.utility.Popup;

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
    private TextField researchBar1;

    @FXML
    private Label ruolo;

    @FXML
    private Label username;

    @FXML
    private Button searchbuttom;

    DataSingleton info = DataSingleton.getInstance();

    @FXML
    private Button carrello;




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
    void logout() throws ExceptionSwitchpage {


        LogoutAction.logout();
    }

    public void sitename1(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

        }

}


