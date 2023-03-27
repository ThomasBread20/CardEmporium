package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import java.io.IOException;

public class HNRview {

    @FXML
    private Pane base;

    @FXML
    private Button buttomLogin;

    @FXML
    private Button buttomRegister;

    @FXML
    private Text testoCard;



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

