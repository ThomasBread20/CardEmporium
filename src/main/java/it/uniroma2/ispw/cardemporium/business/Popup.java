package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;

import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

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
            throw new ExceptionSwitchpage("Popup failed");
        }





    }


    public static void notSeller(ActionEvent event, String role) throws ExceptionSwitchpage {



        if (role.equals("Venditore")) {
            try {
                SwitchPage page = new SwitchPage();
                page.switchPage("schermata_venditore1", event);
            }catch (ExceptionSwitchpage | IOException e) {
                throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
            }



        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You are not a Seller!");
            alert.setHeaderText("Became a Seller for sell your cards!");
            alert.show();
        }

    }

    public static String shoppingcart(int i) throws ExceptionSwitchpage {
        try {
            if(i == 1){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CardEmporium");
                alert.setHeaderText("Do you want to put this card in your Shopping Cart?");

                if (alert.showAndWait().orElse(null) == ButtonType.OK) {
                    return "yes";
                } else {
                    return "no";
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CardEmporium");
                alert.setHeaderText("Do you want to buy all cards in your Shopping Cart?");

                if (alert.showAndWait().orElse(null) == ButtonType.OK) {
                    return "yes";
                } else {
                    return "no";
                }
            }
        } catch (Exception e) {
            throw new ExceptionSwitchpage("Popup failed");
        }
    }


        public static void cardNoExist() throws ExceptionSwitchpage {
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Notification!");
                alert.setHeaderText("This Card do not exist!");
                alert.showAndWait();
            } catch (Exception e) {
                throw new ExceptionSwitchpage("Popup");
            }




    }

    public static String removeCardFromSC() throws ExceptionSwitchpage {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CardEmporium");
            alert.setHeaderText("Do you want to remove this card from your Shopping Cart?");

            if (alert.showAndWait().orElse(null) == ButtonType.OK) {
                return "yes";
            } else {
                return "no";
            }
        } catch (Exception e) {
            throw new ExceptionSwitchpage("Popup");
        }
    }


    private Popup(){}
}
