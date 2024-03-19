package it.uniroma2.ispw.cardemporium.ui;


import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.ui.Simone.*;
import it.uniroma2.ispw.cardemporium.ui.thomas.CardView;
import it.uniroma2.ispw.cardemporium.ui.thomas.Carrelloview;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

//rendere questa classe astratta

public class SwitchPage {
    static String xml=".fxml";



    public void switchPage(String value, ActionEvent event) throws IOException, ExceptionSwitchpage {


        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(viewRegisterScene);
            window.show();

        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");
        }
    }



    public static YugiohView switchPagesellerY(String value, ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            YugiohView sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View2");
        }
    }
    public static Object switchPageseller(String value,ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Object sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View3");
        }
    }

    public static PokemonView switchPagesellerP(String value, ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            PokemonView sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View4");
        }
    }
    public static MagicView switchPagesellerM(String value, ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            MagicView sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View");
        }
    }
    public static Dgview switchPagesellerDG(String value, ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Dgview sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View5");
        }
    }


    public ManageCardsView switchPageMC(String value, ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value+ xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           ManageCardsView sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View8");
        }

    }









}
