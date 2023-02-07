package it.uniroma2.ispw.cardEmporium.ui;

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
    private Label Nome;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

    @FXML
    private Label ruolo;

    @FXML
    private Label username;


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

        if (alert.showAndWait().orElse(null) == ButtonType.OK) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata login.fxml"));
            Parent ViewRegister = loader.load();
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();

        }

    }
    @FXML

    public void HomeButton (ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_home_admin.fxml"));
        Parent ViewRegister = loader.load();
        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewRegisterScene);
        window.show();

    }
}