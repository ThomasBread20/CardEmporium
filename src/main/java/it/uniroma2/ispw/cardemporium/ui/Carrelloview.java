package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.controller.ShoppingController;
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

public class Carrelloview {

    @FXML
    private Button Homebutton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button SellButton;

    @FXML
    private Button carrello;

    @FXML
    private TableView<CopiaCardCarrello> TableList;


    @FXML
    private TableColumn<CopiaCardCarrello, Integer> id;

    @FXML
    private TableColumn<CopiaCardCarrello, String> nome;

    @FXML
    private TableColumn<CopiaCardCarrello, Double> prezzo;
    @FXML
    private TableColumn<CopiaCardCarrello, String> venditore;
    @FXML
    private TableColumn<CopiaCardCarrello, String> extra;
    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;


    @FXML
    void Homebutton(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

    }



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
    public void modifytable(ObservableList<CopiaCardCarrello> card) {

        id.setCellValueFactory(new PropertyValueFactory<>("cartaID"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nomeCarta"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("UtenteVenditore"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));


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

    public void Scarrello(ActionEvent event) throws ExceptionSwitchpage, ExceptionDBerror, ExceptionCardNotExist, SQLException, IOException {

      try{
          ShoppingController.refreshCartView(event);
      }catch (ExceptionSwitchpage e){
          throw new ExceptionSwitchpage("erroreswitchpage");
      }catch (ExceptionDBerror e) {
          throw new ExceptionDBerror("erroreDB");
      }

    }



    public void Removecard(MouseEvent mouseEvent) throws ExceptionSwitchpage, ExceptionCardNotExist {

        int index = TableList.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        String returnValue = Popup.shoppingcart();

        if(returnValue.equals("yes")){

            try{
                BuyCardApplicativo.removeCard(id.getCellData(index));
                SwitchPage page = SwitchPage.getInstance();

                ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());



                Carrelloview Carrelloview = page.switchPageDataM("Schermata_Carrello", mouseEvent);


                Carrelloview.modifytable(cards);



            }catch(ExceptionDBerror e){
                System.out.printf("errore db");
            } catch (ExceptionCardNotExist e) {
                throw new ExceptionCardNotExist("erroreswitchapgee");
            } catch (SQLException e) {
                System.out.printf("errore db");;
            }

        }
    }

    DataSingleton inf = DataSingleton.getInstance();

    public void buy(ActionEvent event) throws ExceptionDBerror, ExceptionSwitchpage, ExceptionCardNotExist {

        try{

            ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());
            int value = inf.getID();
            while(!cards.isEmpty()) {
                int n = 0;
                CopiaCardCarrello carta = cards.get(n);


                cards.remove(n);

                ShoppingController.shopping(carta.getCartaID(),value);

                n++;
            }
            ShoppingController.refreshCartView(event);
        }catch (ExceptionDBerror e){
            throw new ExceptionDBerror("ERRORE");
        } catch (ExceptionCardNotExist e) {
            throw new ExceptionCardNotExist("la carta non esiste");
        } catch (SQLException e) {
            throw new ExceptionDBerror("ERRORE");
        } catch (IOException e) {
             throw new ExceptionDBerror("ERRORE");
        } catch (ExceptionSwitchpage e) {
            throw new ExceptionSwitchpage("erroreswitchpage");
        }
    }
}

