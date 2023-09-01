package it.uniroma2.ispw.cardemporium.ui;




import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
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

    public static CardView switchPageData(String value, ActionEvent event) throws IOException, ExceptionSwitchpage, ExceptionDBerror {

       try {
           FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + ".fxml"));

           Parent viewRegister = loader.load();
           Scene viewRegisterScene = new Scene(viewRegister);

           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           CardView cardView = loader.getController();


           window.setScene(viewRegisterScene);
           window.show();

           return cardView;
       }
    catch ( IOException e) {
        throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
    }

    }


    public static Carrelloview switchPageData1(String value, ActionEvent event) throws IOException, ExceptionSwitchpage, ExceptionDBerror {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchPage.class.getResource(value + ".fxml"));

            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Carrelloview Carrelloview = loader.getController();


            window.setScene(viewRegisterScene);
            window.show();

            return Carrelloview;
        }
        catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }

    }



    public void switchPageCard(ActionEvent event){

    }

}
