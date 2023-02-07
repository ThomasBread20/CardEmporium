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
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;
import java.sql.Date;

public class HRview {



    @FXML
    private Button SellButton;

    @FXML
    private Button LogoutButton;


    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;


    Stage stage;

    DataSingleton info = DataSingleton.getInstance();

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
    void profileButton(ActionEvent event) throws IOException {



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

    @FXML
    void Sell(ActionEvent event) throws IOException {


        String Role = info.getRole();

        if(Role.equals("Venditore")){
            Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata_venditore1.fxml"));
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You are not a Seller!");
            alert.setHeaderText("Became a Seller for sell your cards!");
            alert.show();
        }






    }


}
