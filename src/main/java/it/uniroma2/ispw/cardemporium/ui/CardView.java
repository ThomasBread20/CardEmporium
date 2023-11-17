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
    private Button logoutButton;

    @FXML
    private Label nome;

    @FXML
    private Button sellButton;

    @FXML
    private TableView<CopiaCard> tableList;

    @FXML
    private TableColumn<CopiaCard,String> condizione;

    @FXML
    private TableColumn<CopiaCard, Integer> id;
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
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button homeButton1;

    @FXML
    private Button searchbuttom;

    @FXML
    private Button carrello;

    public void scarrello(ActionEvent event) throws ExceptionSwitchpage, ExceptionDBerror {



        try{

            ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());



            Carrelloview carrelloview = SwitchPage.switchPageData1("Schermata_Carrello", event);


            carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            e.getErrorCode();
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
    void search(ActionEvent event) throws SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage {



        try{
            ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard(researchBar.getText());






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

            Popup.cardNoExist();

        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


    }

    Integer index;


    Stage stage;

    DataSingleton info = DataSingleton.getInstance();




    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);

    }

    @FXML
    void sell(ActionEvent event) throws ExceptionSwitchpage {

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


    public void initData1(String name, String gioco1) {


        nome.setText(name);
        gioco.setText(gioco1);



    }



    public void modifytable(ObservableList<CopiaCard> card){



        id.setCellValueFactory(new PropertyValueFactory<>("cartaSingolaID"));
        condizione.setCellValueFactory(new PropertyValueFactory<>("condizione"));
        lingua.setCellValueFactory(new PropertyValueFactory<>("Lingua"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("UtenteVenditore"));
        setgioco.setCellValueFactory(new PropertyValueFactory<>("nomeSet"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));




        tableList.setItems(card);




    }



    public void shoppingCART(MouseEvent mouseEvent) throws ExceptionSwitchpage, ExceptionDBerror {

        index = tableList.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        String returnValue = Popup.shoppingcart();

        if(returnValue.equals("yes")){

            try{
                BuyCardApplicativo.addCard(id.getCellData(index));

                BuyCardApplicativo.refreshCardView(nome.getText(), mouseEvent,gioco.getText());




            }catch(ExceptionDBerror | ExceptionCardNotExist | SQLException | IOException e){
                e.getCause();

            }

        }

    }
}


