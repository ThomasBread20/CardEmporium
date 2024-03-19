package it.uniroma2.ispw.cardemporium.ui.Simone;

import it.uniroma2.ispw.cardemporium.bean.simone.CardBean;
import it.uniroma2.ispw.cardemporium.bean.simone.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.simone.ExtraBeanY;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.simone.InsertCardController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import it.uniroma2.ispw.cardemporium.model.simone.Card;
import it.uniroma2.ispw.cardemporium.ui.Profiloview;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
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
import java.util.ResourceBundle;

public class YugiohView implements Initializable {
    DataSingleton info = DataSingleton.getInstance();
    private final String[]language={"Italian","French","German","English"};
    @FXML
    private ChoiceBox<String> choiceOne;

    private  final String[]conditions={"Near mint","Excellent","Good","Light played","Poor"};
    @FXML
    private ChoiceBox<String> choiceTwo;
    @FXML
    private TextField price;

    @FXML
    private TextField quan;
    @FXML
    private TableColumn<Card, Integer> cardid;
    @FXML
    private TableColumn<Card,String> gameName;
    @FXML
    private TableColumn<Card,String> nameCard;
    @FXML
    private TableView<Card> tableview;
    @FXML
    private TableColumn<Card,Integer> vers;
    @FXML
    private TableColumn<Card,String> setName;
    @FXML
    private CheckBox alteredy;
    @FXML
    private CheckBox feditiony;
    @FXML
    private CheckBox signedy;

    @FXML
    void goback(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = new SwitchPage();
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
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata home");
        }
    }
    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);
    }

    public void shCart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {

        /*CardController view = new CardController();

        try {

            ObservableList<CarrelloEntity> cards = view.searchCard1(view.getID());


            Carrelloview carrelloview = SwitchPage.switchPageShoppingCart("Schermata_Carrello", actionEvent);


            carrelloview.modifytable(cards);


        } catch (ExceptionCardNotExist e) {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        } catch (IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            e.getErrorCode();
        }*/
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
        vers.setCellValueFactory(new PropertyValueFactory<>("version"));
        setName.setCellValueFactory(new PropertyValueFactory<>("SetName"));
        gameName.setCellValueFactory(new PropertyValueFactory<>("nomegioco"));

        tableview.setItems(cards);
    }

    public void expose(ActionEvent actionEvent) {
        boolean al= alteredy.isSelected();
        boolean sig= signedy.isSelected();
        boolean f= feditiony.isSelected();
        SwitchPage page = new SwitchPage();
        
        Float prezzo= Float.valueOf(price.getText());
        Integer q= Integer.valueOf(quan.getText());
        String name= String.valueOf(nameCard.getCellObservableValue(0).getValue());
        Integer id= cardid.getCellObservableValue(0).getValue();
        InsertCardController insertCardController=new InsertCardController();
        Integer ver= vers.getCellObservableValue(0).getValue();
        String game= gameName.getCellObservableValue(0).getValue();
        String set= setName.getCellObservableValue(0).getValue();
        ExtraBeanY extraBeanY=new ExtraBeanY(id,ver,name,al,sig,f);
        CardBean cardBean=new CardBean(name,ver,game,set);
        CardInfoBean cardInfoBean=new CardInfoBean(id,cardBean,(String) verifyCon(),prezzo,q,extraBeanY, (String) verifyLan());
        try {
            insertCardController.insertCardY(cardInfoBean);
            page.switchPage("schermata_venditore1",actionEvent);
        } catch (IOException | ExceptionSwitchpage | Exceptionquantity e) {
            e.getCause();
        }


    }
}
