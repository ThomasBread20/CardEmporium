package it.uniroma2.ispw.cardEmporium.ui;

import it.uniroma2.ispw.cardEmporium.business.DataSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class Profiloview {

    @FXML
    private Button HomeButtom;

    @FXML
    private Button LogoutButton;

    @FXML
    private Label Nome;

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
    private Label ruolo;

    @FXML
    private Label username;

    DataSingleton info = DataSingleton.getInstance();

    public void initData(String user, String name, String surname, String born, String role) {

        username.setText(user);
        Nome.setText(name);
        cognome.setText(surname);
        datanascita.setText(born);
        ruolo.setText(role);
    }


    @FXML
    void Logout(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("you're about to logout!");

        if(alert.showAndWait().get() == ButtonType.OK){

            Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata login.fxml"));
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();
        }
    }

    @FXML
    void Sell(ActionEvent event) throws IOException {


        String Role = info.getRole();

        if (Role.equals("Venditore")) {
            Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata_venditore1.fxml"));
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You are not a Seller!");
            alert.setHeaderText("Became a Seller for sell your cards!");
            alert.show();
        }

    }

    public void sitename1(ActionEvent event) throws IOException {
        Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata_home_registrato.fxml"));
        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewRegisterScene);
        window.show();
        }

}


