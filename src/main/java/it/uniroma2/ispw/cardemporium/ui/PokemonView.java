package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanG;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanP;
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

public class PokemonView implements Initializable {
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
    private TableColumn<Card, Integer> cardId;
    @FXML
    private TableColumn<Card,String> gamename;
    @FXML
    private TableColumn<Card,String> namecard;
    @FXML
    private TableView<Card> tableview;
    @FXML
    private TableColumn<Card,Integer> version;
    @FXML
    private TableColumn<Card,String> setname;
    @FXML
    private CheckBox alteredp;
    @FXML
    private CheckBox feditionp;
    @FXML
    private CheckBox playsetp;
    @FXML
    private CheckBox reverseh;
    @FXML
    private CheckBox signedp;
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

    public void shoppingCart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {


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
            e.getErrorCode();
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
        cardId.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecard.setCellValueFactory(new PropertyValueFactory<>("name"));
        version.setCellValueFactory(new PropertyValueFactory<>("version"));
        setname.setCellValueFactory(new PropertyValueFactory<>("SetName"));
        gamename.setCellValueFactory(new PropertyValueFactory<>("nomeGioco"));

        tableview.setItems(cards);
    }

    public void expose(ActionEvent actionEvent) {
        boolean s= signedp.isSelected();
        boolean al= alteredp.isSelected();
        boolean fed= feditionp.isSelected();
        boolean pla= playsetp.isSelected();
        boolean rev=reverseh.isSelected();
        SwitchPage page=SwitchPage.getInstance();

        Float prezzo= Float.valueOf(price.getText());
        Integer q= Integer.valueOf(quantity.getText());
        String name= String.valueOf(namecard.getCellObservableValue(0).getValue());
        Integer id= cardId.getCellObservableValue(0).getValue();

        Integer ver= version.getCellObservableValue(0).getValue();
        String game= gamename.getCellObservableValue(0).getValue();
        String set= setname.getCellObservableValue(0).getValue();
        ExtraBeanG extraBeanG=new ExtraBeanG(al,s,fed,rev,pla);
        ExtraBeanP extraBeanP=new ExtraBeanP(id,name,ver,extraBeanG);
        CardBean cardBean=new CardBean(name,ver,game,set);
        CardInfoBean cardInfoBean=new CardInfoBean(id,cardBean,(String) verifyCon(),prezzo,q,extraBeanP, (String) verifyLan());
        try {
            cardInfoBean.insertCardP();
            page.switchPage("schermata_venditore1",actionEvent);
        } catch (IOException | ExceptionSwitchpage | Exceptionquantity e) {
            e.getCause();
        }


    }
}
