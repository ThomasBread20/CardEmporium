package it.uniroma2.ispw.cardEmporium.ui;

import it.uniroma2.ispw.cardEmporium.business.DataSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Adminview {



    DataSingleton info = DataSingleton.getInstance();

    @FXML
    void profileButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfiloAdmin.fxml"));
        Parent ViewRegister = loader.load();
        Scene ViewRegisterScene = new Scene(ViewRegister);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ProfiloAdminview ProfiloAdminview = loader.getController();
        ProfiloAdminview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(ViewRegisterScene);
        window.show();

    }

    @FXML
    void Logout(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("you're about to logout!");

        if(alert.showAndWait().orElse(null) == ButtonType.OK){


            FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata login.fxml"));
            Parent ViewRegister = loader.load();
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();
        }
    }

}
