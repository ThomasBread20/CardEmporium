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
    static String xml=".fxml";


    private static final SwitchPage instance = new SwitchPage();

    public static SwitchPage getInstance(){
        return instance;
    }
    public void switchPage(String value, ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            Parent viewRegister = FXMLLoader.load(getClass().getResource(value + xml));
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();



            window.setScene(viewRegisterScene);
            window.show();

        } catch (IOException e) {
            throw new ExceptionSwitchpage("error switch page ");
        }


    }

    public static CardView switchPageData(String value, ActionEvent event) throws IOException, ExceptionSwitchpage {

       try {
           FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value +xml));

           Parent viewRegister = loader.load();
           Scene viewRegisterScene = new Scene(viewRegister);

           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           CardView cardView = loader.getController();


           window.setScene(viewRegisterScene);
           window.show();

           return cardView;
       }
    catch ( IOException e) {
        throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");
    }

    }
    public static YugiohView switchPagesellerY(String value,ActionEvent event) throws ExceptionSwitchpage {
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
    public static magicView switchPagesellerM(String value,ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            magicView sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View");
        }
    }
    public static dgView switchPagesellerDG(String value,ActionEvent event) throws ExceptionSwitchpage {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            dgView sellerview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return sellerview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Seller3 Login View5");
        }
    }



    public static Carrelloview switchPageData1(String value, ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Carrelloview carrelloview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return carrelloview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page carrello Login View7");
        }

    }
    public ManageCardsView switchPageMC(String value,ActionEvent event) throws ExceptionSwitchpage {
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





    public Carrelloview switchPageDataM(String schermataCarrello, javafx.scene.input.MouseEvent mouseEvent) throws ExceptionSwitchpage {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(schermataCarrello + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Carrelloview carrelloview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return carrelloview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View9");
        }

    }


    public static CardView switchPageDataM1(String value, javafx.scene.input.MouseEvent event) throws IOException, ExceptionSwitchpage{

        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + xml));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            CardView cardView = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return cardView;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View10");
        }

    }

}
