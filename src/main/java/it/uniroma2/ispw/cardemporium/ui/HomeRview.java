package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.ObservableList;
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
import java.sql.SQLException;
import java.util.ArrayList;

public class HomeRview {



    @FXML
    private Button LogoutButton;

    @FXML
    private Button SellButton;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;



    @FXML
    void Search(ActionEvent event) throws SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage {



       try{
           ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard(researchBar.getText());



           /*SwitchPage page = SwitchPage.getInstance();
           page.switchPage("Schermata_Carta", event);*/

           FXMLLoader loader = new FXMLLoader(getClass().getResource("Schermata_Carta.fxml"));
           Parent viewRegister = loader.load();
           Scene viewRegisterScene = new Scene(viewRegister);

           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           CardView cardView = loader.getController();



           cardView.initData1(cards.get(0).getNomeCarta(), cards.get(0).getNomeGioco());
           cardView.modifytable(cards);


           window.setScene(viewRegisterScene);
           window.show();




       }catch (ExceptionCardNotExist e)
       {

           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Notification!");
           alert.setHeaderText("This Card do not exist!");
           alert.showAndWait();

       }catch ( IOException e) {
           throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
       }


       catch (ExceptionDBerror  e) {
           throw new ExceptionDBerror("value");


       }


    }







    Stage stage;

    DataSingleton info = DataSingleton.getInstance();



    @FXML
    void Logout(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfilo.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Profiloview profiloview = loader.getController();

        profiloview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(viewRegisterScene);
        window.show();
    }

    @FXML
    void Sell(ActionEvent event) throws  ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);






    }



}
