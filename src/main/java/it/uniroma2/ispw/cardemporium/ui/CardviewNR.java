package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CardviewNR {

    @FXML
    private Button buttomLogin;

    @FXML
    private Button buttomRegister;

    @FXML
    private Label nome;

    @FXML
    private TableView<CopiaCard> tableList;

    @FXML
    private TableColumn<CopiaCard,String> condizione;
    @FXML
    private TableColumn<CopiaCard, String> lingua;

    @FXML
    private TableColumn<CopiaCard, Double> prezzo;
    @FXML
    private TableColumn<CopiaCard, String> venditore;

    @FXML
    private TableColumn<CopiaCard, String> setgioco;

    @FXML
    private TableColumn<CopiaCard, String> extra;

    @FXML
    private Label gioco;




    @FXML
    private TextField researchBar;


    @FXML
    private Text testoCard;

    @FXML
    private Button cardemporium;

    @FXML
    private Button searchbuttom;



    @FXML
    void search(ActionEvent event) throws SQLException, ExceptionSwitchpage {
        try{
            ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard(researchBar.getText());





            FXMLLoader loader = new FXMLLoader(getClass().getResource("Schermata_CartaNR.fxml"));
            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            CardviewNR cardView = loader.getController();



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


    }



    @FXML
    void homebutton(ActionEvent event) throws ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata home non registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata non registrazione Login View");
        }

    }


    @FXML
    public void login(ActionEvent event) throws IOException, ExceptionSwitchpage {


        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata login", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }
    }

    @FXML
    public void register(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata registrazione", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }
    }


    public void initData1(String name, String gioco1) {

        nome.setText(name);
        gioco.setText(gioco1);



    }



    public void modifytable(ObservableList<CopiaCard> card){


        condizione.setCellValueFactory(new PropertyValueFactory<>("condizione"));
        lingua.setCellValueFactory(new PropertyValueFactory<>("lingua"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("utenteVenditore"));
        setgioco.setCellValueFactory(new PropertyValueFactory<>("nomeSet"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));


        tableList.setItems(card);
    }

}
