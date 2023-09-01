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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Carrelloview {

    @FXML
    private Button LogoutButton;

    @FXML
    private Button SellButton;

    @FXML
    private TableView<CopiaCard> TableList;

    @FXML
    private TableColumn<CopiaCard, String> nome;

    @FXML
    private TableColumn<CopiaCard, Double> prezzo;
    @FXML
    private TableColumn<CopiaCard, String> venditore;
    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;



    @FXML
    void Logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);

    }

    @FXML
    void Search(ActionEvent event) throws SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage{
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

            Popup.CardNoExist();

        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        }


    }
    public void modifytable(ObservableList<CopiaCard> card) {


        nome.setCellValueFactory(new PropertyValueFactory<>("nomeCarta"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("UtenteVenditore"));


        TableList.setItems(card);


    }
    @FXML
    void Sell(ActionEvent event) throws ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);



    }

    Stage stage;

    DataSingleton info = DataSingleton.getInstance();
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
    void tablelist(ActionEvent event) {

    }

    public void Scarrello(ActionEvent event) {
    }
}
