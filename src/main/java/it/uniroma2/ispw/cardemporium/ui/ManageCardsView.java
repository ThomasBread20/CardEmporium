package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ManageCardsView {
    @FXML
    private TableView<CopiaCard> cardlistTable;

    @FXML
    private TableColumn<?, ?> cond;
    @FXML
    private TableColumn<?, ?> lan;
    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> price;
    @FXML
    private TableColumn<?, ?> qty;

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
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", actionEvent);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata home");
        }
    }

    public void logout(ActionEvent actionEvent) throws ExceptionSwitchpage {
        LogoutAction.logout(actionEvent);
    }

    public void goback(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_venditore1", actionEvent);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata seller");
        }
    }

    public void GoToCart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {
        SwitchPage page = SwitchPage.getInstance();


        try{

            ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());



            Carrelloview Carrelloview = page.switchPageData1("Schermata_Carrello", actionEvent);


            Carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

/*
    public void GotoSell(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_venditore1", actionEvent);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata seller");
        }
    }*/
    public void modify_table(ObservableList<CopiaCard> copiaCards){
        name.setCellValueFactory(new PropertyValueFactory<>("nomeCarta"));
        lan.setCellValueFactory(new PropertyValueFactory<>("lingua"));
        cond.setCellValueFactory(new PropertyValueFactory<>("condizione"));
        price.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        qty.setCellValueFactory(new PropertyValueFactory<>("q"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));
        cardlistTable.setItems(copiaCards);
    }
}
