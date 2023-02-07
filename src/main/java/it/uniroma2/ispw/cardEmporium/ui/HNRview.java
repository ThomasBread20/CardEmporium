package it.uniroma2.ispw.cardEmporium.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HNRview {

    @FXML
    private Pane Base;

    @FXML
    private Button ButtomLogin;

    @FXML
    private Button ButtomRegister;

    @FXML
    private Text testoCard;



    @FXML
    public void Login(ActionEvent event) throws IOException {
        Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata login.fxml"));
        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewRegisterScene);
        window.show();

    }

    @FXML
    public void Register(ActionEvent event) throws IOException  {
        Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata registrazione.fxml"));
        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewRegisterScene);
        window.show();

    }

}

