package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

public class Profiloview {

    @FXML
    private Button homeButtom;

    @FXML
    private Button logoutButton;

    @FXML
    private Label nome;

    @FXML
    private Button sellButton;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar1;

    @FXML
    private Label ruolo;

    @FXML
    private Label username;

    @FXML
    private Button searchbuttom;

    DataSingleton info = DataSingleton.getInstance();

    public void initData(String user, String name, String surname, String born, String role) {
        username.setText(user);
        nome.setText(name);
        cognome.setText(surname);
        datanascita.setText(born);
        ruolo.setText(role);
    }


    @FXML
    void Search(ActionEvent event) throws SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage {



        try{
            ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard(researchBar1.getText());



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




    @FXML
    void sell(ActionEvent event) throws  ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);


    }

    @FXML
    void logout(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    public void sitename1(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

        }

}


