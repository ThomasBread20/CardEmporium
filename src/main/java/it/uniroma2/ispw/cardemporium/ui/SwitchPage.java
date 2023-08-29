package it.uniroma2.ispw.cardemporium.ui;




import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchPage {


    private static final SwitchPage instance = new SwitchPage();

    public static SwitchPage getInstance(){
        return instance;
    }
    public void switchPage(String value, ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            Parent viewRegister = FXMLLoader.load(getClass().getResource(value + ".fxml"));
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();



            window.setScene(viewRegisterScene);
            window.show();

        } catch (IOException e) {
            throw new ExceptionSwitchpage("error switch page ");
        }


    }

}
