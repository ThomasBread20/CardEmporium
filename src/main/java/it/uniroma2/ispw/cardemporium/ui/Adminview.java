package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Adminview {



    DataSingleton info = DataSingleton.getInstance();

    @FXML
    void profileButton(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfiloAdmin.fxml"));
        Parent viewregister = loader.load();
        Scene viewregisterscene = new Scene(viewregister);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ProfiloAdminview profiloadminview = loader.getController();
        profiloadminview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(viewregisterscene);
        window.show();


    }

    @FXML
    void logoutAdmin(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

}
