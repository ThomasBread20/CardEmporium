package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanP;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class pokemonView implements Initializable {
    DataSingleton info = DataSingleton.getInstance();
    private String[]language={"Italian","French","German","English"};
    @FXML
    private ChoiceBox<String> choiceOne;

    private String[]conditions={"Near mint","Excellent","Good","Light played","Poor"};
    @FXML
    private ChoiceBox<String> choiceTwo;
    @FXML
    private TextField Price;

    @FXML
    private TextField Quantity;
    @FXML
    private TableColumn<Card, Integer> card_id;
    @FXML
    private TableColumn<Card,String> game_name;
    @FXML
    private TableColumn<Card,String> name_card;
    @FXML
    private TableView<Card> tableview;
    @FXML
    private TableColumn<Card,Integer> num_version;
    @FXML
    private TableColumn<Card,String> set_name;
    @FXML
    private CheckBox altered_p;
    @FXML
    private CheckBox fedition_p;
    @FXML
    private CheckBox playset_p;
    @FXML
    private CheckBox reverseh;
    @FXML
    private CheckBox signed_p;
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

    public void Shopping_Cart(ActionEvent actionEvent) throws ExceptionSwitchpage, ExceptionDBerror {
        SwitchPage page = SwitchPage.getInstance();


        try {

            ObservableList<CopiaCardCarrello> cards = BuyCardApplicativo.searchCard1(BuyCardApplicativo.getID());


            Carrelloview Carrelloview = page.switchPageData1("Schermata_Carrello", actionEvent);


            Carrelloview.modifytable(cards);


        } catch (ExceptionCardNotExist e) {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        } catch (IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getQuantitiy(ActionEvent actionEvent) {
    }

    public void getPrice(ActionEvent actionEvent) {
    }

    public void getCond(MouseEvent mouseEvent) {
    }

    public void getLang(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceOne.getItems().addAll(language);
        choiceTwo.getItems().addAll(conditions);
    }
    public Object verify_Lan() {
        Object str;
        Object r = choiceOne.getValue();
        if (r != null) {
            str = r;
        } else {
            str = null;
        }
        return str;
    }
    public Object verify_Con() {
        Object str;
        Object r = choiceTwo.getValue();
        if (r != null) {
            str = r;
        } else {
            str = null;
        }
        return str;
    }
    public void populate_table(ObservableList<Card> cards){
        card_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_card.setCellValueFactory(new PropertyValueFactory<>("name"));
        num_version.setCellValueFactory(new PropertyValueFactory<>("version"));
        set_name.setCellValueFactory(new PropertyValueFactory<>("SetName"));
        game_name.setCellValueFactory(new PropertyValueFactory<>("nomeGioco"));

        tableview.setItems(cards);
    }
    public void print(){
        String name= String.valueOf(name_card.getCellObservableValue(0).getValue());
        System.out.println(name);
    }
    public void Expose(ActionEvent actionEvent) {
        boolean s=signed_p.isSelected();
        boolean al=altered_p.isSelected();
        boolean fed=fedition_p.isSelected();
        boolean pla=playset_p.isSelected();
        boolean rev=reverseh.isSelected();

        Float prezzo= Float.valueOf(Price.getText());
        Integer q= Integer.valueOf(Quantity.getText());
        String name= String.valueOf(name_card.getCellObservableValue(0).getValue());
        Integer id=card_id.getCellObservableValue(0).getValue();

        Integer ver=num_version.getCellObservableValue(0).getValue();
        String game=game_name.getCellObservableValue(0).getValue();
        String set=set_name.getCellObservableValue(0).getValue();

        CardInfoBean cardInfoBean=new CardInfoBean(id,name,ver,game,set,(String) verify_Con(),prezzo,q, (String) verify_Lan());
        ExtraBeanP extraBeanP=new ExtraBeanP(al,id,name,ver,s,fed,pla,rev);
        try {
            cardInfoBean.InsertCard(actionEvent);
        } catch (ExceptionDBerror e) {
            throw new RuntimeException(e);
        }


    }
}
