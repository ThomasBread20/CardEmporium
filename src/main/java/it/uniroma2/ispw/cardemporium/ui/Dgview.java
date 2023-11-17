package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanDG;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dgview implements Initializable {

    DataSingleton info = DataSingleton.getInstance();
    private String[]language={"Italian","French","German","English"};
    @FXML
    private ChoiceBox<String> choiceOne;

    private String[]conditions={"Near mint","Excellent","Good","Light played","Poor"};
    @FXML
    private ChoiceBox<String> choiceTwo;
    @FXML
    private TextField price;

    @FXML
    private TextField quan;
    @FXML
    private TableColumn<Card, Integer> cardid;
    @FXML
    private TableColumn<Card,String> gamename;
    @FXML
    private TableColumn<Card,String> nameCard;
    @FXML
    private TableView<Card> tableview;
    @FXML
    private TableColumn<Card,Integer> ver;
    @FXML
    private TableColumn<Card,String> setname;
    @FXML
    private CheckBox altereddg;
    @FXML
    private CheckBox signeddg;
    @FXML
    private CheckBox foildg;
    @FXML
    void goback(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("venditore2", event);

        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata venditore2");
        }
    }

    @FXML
    void goProfile(ActionEvent event) throws IOException {
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
    void goHome(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata home");
        }
    }
    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);
    }

    public void shoppinCart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {


        try {

            ObservableList<CopiaCardCarrello> cards = BuyCardApplicativo.searchCard1(BuyCardApplicativo.getID());


            Carrelloview carrelloview = SwitchPage.switchPageData1("Schermata_Carrello", actionEvent);


            carrelloview.modifytable(cards);


        } catch (ExceptionCardNotExist e) {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        } catch (IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            e.getCause();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceOne.getItems().addAll(language);
        choiceTwo.getItems().addAll(conditions);
    }
    public Object verifyLan() {
        Object str;
        Object r = choiceOne.getValue();
        if (r != null) {
            str = r;
        } else {
            str = null;
        }
        return str;
    }
    public Object verifyCon() {
        Object str;
        Object r = choiceTwo.getValue();
        if (r != null) {
            str = r;
        } else {
            str = null;
        }
        return str;
    }
    public void populateTable(ObservableList<Card> cards){
        cardid.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCard.setCellValueFactory(new PropertyValueFactory<>("name"));
        ver.setCellValueFactory(new PropertyValueFactory<>("version"));
        setname.setCellValueFactory(new PropertyValueFactory<>("SetName"));
        gamename.setCellValueFactory(new PropertyValueFactory<>("nomeGioco"));

        tableview.setItems(cards);
    }

    public void expose(ActionEvent actionEvent) {
        SwitchPage page=SwitchPage.getInstance();
        boolean alt= altereddg.isSelected();
        boolean sig= signeddg.isSelected();
        boolean foil= foildg.isSelected();


        Float prezzo= Float.valueOf(price.getText());
        Integer q= Integer.valueOf(quan.getText());
        String name= String.valueOf(nameCard.getCellObservableValue(0).getValue());
        Integer id= cardid.getCellObservableValue(0).getValue();

        Integer version= this.ver.getCellObservableValue(0).getValue();
        String game= gamename.getCellObservableValue(0).getValue();
        String set= setname.getCellObservableValue(0).getValue();
        ExtraBeanDG extraBeanDG=new ExtraBeanDG(sig,alt,foil,id,version,name);
        CardBean cardBean=new CardBean(name,version,game,set);
        CardInfoBean cardInfoBean=new CardInfoBean(id,cardBean,(String) verifyCon(),prezzo,q,extraBeanDG, (String) verifyLan());

        try {

            cardInfoBean.insertCardDB();
            page.switchPage("schermata_venditore1",actionEvent);
        } catch (IOException | ExceptionSwitchpage | Exceptionquantity e) {
            e.getCause();
        }


    }
}

