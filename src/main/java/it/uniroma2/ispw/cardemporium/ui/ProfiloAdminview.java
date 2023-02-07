package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ProfiloAdminview {



    @FXML
    private Label nome;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

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
    void logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("you're about to logout!");

        Optional<ButtonType> test = alert.showAndWait();

        if((test.isPresent() && test.get() == ButtonType.OK )){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata login.fxml"));
            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(viewRegisterScene);
            window.show();

        }

    }
    @FXML

    public void homeButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_home_admin.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(viewRegisterScene);
        window.show();

    }

    public void profileButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfiloAdmin.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ProfiloAdminview profiloAdminview = loader.getController();
        profiloAdminview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(viewRegisterScene);
        window.show();
    }
}