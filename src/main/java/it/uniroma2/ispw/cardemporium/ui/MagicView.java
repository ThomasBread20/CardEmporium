package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanM;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.controller.InsertCardController;
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

public class MagicView implements Initializable {
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
    private TextField quantity;
    @FXML
    private TableColumn<Card, Integer> idCard;
    @FXML
    private TableColumn<Card,String> gameName;
    @FXML
    private TableColumn<Card,String> nameCard;
    @FXML
    private TableView<Card> tableview;
    @FXML
    private TableColumn<Card,Integer> version;
    @FXML
    private TableColumn<Card,String> setName;
    @FXML
    private CheckBox alteredm;
    @FXML
    private CheckBox signedm;
    @FXML
    private CheckBox foilm;
    @FXML
    private CheckBox playsetm;
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

    public void shopCart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {


        BuyCardApplicativo view = new BuyCardApplicativo();
        try {

            ObservableList<CopiaCardCarrello> cards = view.searchCard1(view.getID());


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
        idCard.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCard.setCellValueFactory(new PropertyValueFactory<>("name"));
        version.setCellValueFactory(new PropertyValueFactory<>("version"));
        setName.setCellValueFactory(new PropertyValueFactory<>("SetName"));
        gameName.setCellValueFactory(new PropertyValueFactory<>("nomeGioco"));

        tableview.setItems(cards);
    }

    public void expose(ActionEvent actionEvent) throws Exceptionquantity {
        boolean si= signedm.isSelected();
        boolean al= alteredm.isSelected();
        boolean pl= playsetm.isSelected();
        boolean f= foilm.isSelected();
        SwitchPage page=SwitchPage.getInstance();

        Float prezzo= Float.valueOf(price.getText());
        Integer q= Integer.valueOf(quantity.getText());
        String name= String.valueOf(nameCard.getCellObservableValue(0).getValue());
        Integer id= idCard.getCellObservableValue(0).getValue();
        InsertCardController insertCardController=new InsertCardController();
        Integer ver= version.getCellObservableValue(0).getValue();
        String game= gameName.getCellObservableValue(0).getValue();
        String set= setName.getCellObservableValue(0).getValue();
        ExtraBeanM extraBeanM=new ExtraBeanM(si,al,f,pl,id,ver,name);
        CardBean cardBean=new CardBean(name,ver,game,set);
        CardInfoBean cardInfoBean=new CardInfoBean(id,cardBean,(String) verifyCon(),prezzo,q,extraBeanM, (String) verifyLan());
        try {
            insertCardController.insertCardM(cardInfoBean);
            page.switchPage("schermata_venditore1",actionEvent);
        } catch (IOException | ExceptionSwitchpage e) {
            e.getCause();
        }


    }
}

