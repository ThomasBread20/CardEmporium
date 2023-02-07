package it.uniroma2.ispw.cardEmporium.ui;

import it.uniroma2.ispw.cardEmporium.business.DataSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Sellerview {

    @FXML
    private Button HomeRegistrat;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button profileButton;


    DataSingleton info = DataSingleton.getInstance();
    @FXML
    void Logout(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("you're about to logout!");

        if (alert.showAndWait().get() == ButtonType.OK) {

            Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata login.fxml"));
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();
        }
    }

    @FXML
    public void HomeRegistrato(ActionEvent event) throws IOException {

        Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata_home_registrato.fxml"));
        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewRegisterScene);
        window.show();

    }




    public void profileButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfilo.fxml"));
        Parent ViewRegister = loader.load();
        Scene ViewRegisterScene = new Scene(ViewRegister);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Profiloview Profiloview = loader.getController();
        Profiloview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(ViewRegisterScene);
        window.show();
    }
}
