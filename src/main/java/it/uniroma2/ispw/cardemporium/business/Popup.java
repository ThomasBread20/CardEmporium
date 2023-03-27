package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Popup {


    public static String logout() throws ExceptionSwitchpage {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("you're about to logout!");

            if (alert.showAndWait().orElse(null) == ButtonType.OK) {
                return "yes";
            } else {
                return "no";
            }
        } catch (Exception e) {
            throw new ExceptionSwitchpage("Popup");
        }


    }


}
