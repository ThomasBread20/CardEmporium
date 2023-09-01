package it.uniroma2.ispw.cardemporium.ui;



import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CardView {

    @FXML
    private Button LogoutButton;

    @FXML
    private Label Nome;

    @FXML
    private Button SellButton;

    @FXML
    private TableView<CopiaCard> TableList;

    @FXML
    private TableColumn<CopiaCard,String> condizione;

    @FXML
    private TableColumn<CopiaCard, Integer> ID;
    @FXML
    private TableColumn<CopiaCard, String> lingua;

    @FXML
    private TableColumn<CopiaCard, Double> prezzo;
    @FXML
    private TableColumn<CopiaCard, String> venditore;

    @FXML
    private TableColumn<CopiaCard, String> setgioco;



    @FXML
    private Label gioco;


    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button homeButton1;

    @FXML
    private Button searchbuttom;

    @FXML
    private Button Carrello;

    public void Scarrello(ActionEvent event) throws ExceptionSwitchpage, ExceptionDBerror {

        SwitchPage page = SwitchPage.getInstance();


        try{

            ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());



            Carrelloview Carrelloview = page.switchPageData1("Schermata_Carrello", event);


            Carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




    @FXML
    void  homeButton1(ActionEvent event) throws ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }
    }

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

            Popup.CardNoExist();

        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("value");


        }


    }

    Integer index;


    Stage stage;

    DataSingleton info = DataSingleton.getInstance();




    @FXML
    void Logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);

    }

    @FXML
    void Sell(ActionEvent event) throws ExceptionSwitchpage {

        String role = info.getRole();

        Popup.notSeller(event, role);


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
    void tablelist(ActionEvent event) {

    }
    public void initData1(String name, String gioco1) {

        Nome.setText(name);
        gioco.setText(gioco1);



    }



    public void modifytable(ObservableList<CopiaCard> card){

        ID.setCellValueFactory(new PropertyValueFactory<>("cartaSingolaID"));
        condizione.setCellValueFactory(new PropertyValueFactory<>("condizione"));
        lingua.setCellValueFactory(new PropertyValueFactory<>("Lingua"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("UtenteVenditore"));
        setgioco.setCellValueFactory(new PropertyValueFactory<>("nomeSet"));


        TableList.setItems(card);




    }



    public void ShoppingCART(MouseEvent mouseEvent) throws ExceptionSwitchpage, ExceptionDBerror {

        index = TableList.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        String returnValue = Popup.shoppingcart();

        if(returnValue.equals("yes")){

            try{
                BuyCardApplicativo.addCard(ID.getCellData(index));
                //SwitchPage.switchPageData1("Schermata_Carta", mouseEvent);


            }catch(ExceptionDBerror e){
                System.out.printf("errore db");
            }

        }

    }
}


