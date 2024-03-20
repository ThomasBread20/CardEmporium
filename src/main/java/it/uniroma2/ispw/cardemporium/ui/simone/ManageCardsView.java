package it.uniroma2.ispw.cardemporium.ui.simone;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.simone.CardEntitySImo;
import it.uniroma2.ispw.cardemporium.ui.Profiloview;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageCardsView {
    @FXML
    private TableView<CardEntitySImo> cardlistTable;

    @FXML
    private TableColumn<?, ?> cond;
    @FXML
    private TableColumn<?, ?> lan;
    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> price;


    @FXML
    private TableColumn<?, ?> set;

    @FXML
    private TableColumn<?, ?> ver;
    @FXML
    private TableColumn<?,?>extra;




    DataSingleton info = DataSingleton.getInstance();
    public void profile(ActionEvent event) throws IOException {
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

    public void gohome(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata_home_registrato", actionEvent);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata home");
        }
    }

    void logout() throws ExceptionSwitchpage {


        LogoutAction.logout();
    }

    public void goback(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata_venditore1", actionEvent);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata seller");
        }
    }

    public void goToCart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {

        /*CardController view = new CardController();

        try{

            ObservableList<CarrelloEntity> cards =  view.searchCard1( view.getID());



            Carrelloview carrelloview = SwitchPage.switchPageShoppingCart("Schermata_Carrello", actionEvent);


            carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            e.getErrorCode();
        }*/

    }


    public void modifyTable(ObservableList<CardEntitySImo> copiaCards){
        name.setCellValueFactory(new PropertyValueFactory<>("nomeCarta"));
        lan.setCellValueFactory(new PropertyValueFactory<>("lingua"));
        cond.setCellValueFactory(new PropertyValueFactory<>("condizione"));
        price.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        set.setCellValueFactory(new PropertyValueFactory<>("nomeSet"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));
        ver.setCellValueFactory(new PropertyValueFactory<>("versione"));
        cardlistTable.setItems(copiaCards);
    }
}
