package it.uniroma2.ispw.cardemporium.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CardView{

    @FXML
    private Button LogoutButton;

    @FXML
    private Label Nome;

    @FXML
    private Label Nome1;

    @FXML
    private Label Nome11;

    @FXML
    private Button SellButton;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    void Logout(ActionEvent event) {

    }

    @FXML
    void Sell(ActionEvent event) {

    }

    @FXML
    void profileButton(ActionEvent event) {

    }

    public void initData1(String name,String gioco) {

        Nome.setText(name);
        datanascita.setText(gioco);


    }

}
