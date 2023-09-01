package it.uniroma2.ispw.cardemporium.ui;



import it.uniroma2.ispw.cardemporium.bean.*;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.Card;
import javafx.collections.FXCollections;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Seller3view implements Initializable {

    @FXML
    private Button Back;

    @FXML
    private SplitMenuButton Conditions;

    @FXML
    private SplitMenuButton Language;

    @FXML
    private TextField Price;

    @FXML
    private TextField Quantity;

    @FXML
    private Button Sell;

    @FXML
    private Label cardName;

    @FXML
    private Button goHome;

    @FXML
    private Button logoutButton;

    @FXML
    private Button profile;

    @FXML
    private Text profiloButton;

    @FXML
    void SellCard(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_venditore1", event);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata venditore2");
        }
    }

    DataSingleton info = DataSingleton.getInstance();


    @FXML
    void getCondition(ActionEvent event) {

    }

    @FXML
    void getLanguage(ActionEvent event) {

    }
    private String[]language={"Italian","French","German","English"};
    @FXML
    private ChoiceBox<String> choiceOne;

    private String[]conditions={"Near mint","Excellent","Good","Light played","Poor"};
    @FXML
    private ChoiceBox<String> choiceTwo;

    @FXML
    void getPrice(ActionEvent event) {
        PriceBean price=new PriceBean();
        price.setPriceBeanValue(Double.valueOf(Price.getText()));
    }

    @FXML
    void getQuantitiy(ActionEvent event) {
        QuantityBean qt=new QuantityBean();
        qt.setQuantityBeanValue(Integer.valueOf(Quantity.getText()));
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
    void goback(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("venditore2", event);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata venditore2");
        }
    }

    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceOne.getItems().addAll(language);
        choiceTwo.getItems().addAll(conditions);
    }

    public void getCond(javafx.scene.input.MouseEvent mouseEvent) {
        ConditionBean selected_cond=new ConditionBean();
        String condition=choiceTwo.getSelectionModel().getSelectedItem();
        selected_cond.setConditionBean(condition);

    }

    public void getLang(javafx.scene.input.MouseEvent mouseEvent) {
        LanguageBean selected_lan=new LanguageBean();
        String language=choiceOne.getSelectionModel().getSelectedItem();
        selected_lan.setLanguageBeanValeu(language);

    }
    @FXML
    private Button Expose_button;
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
    public void populate_table(ObservableList<Card> cards){
        card_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_card.setCellValueFactory(new PropertyValueFactory<>("name"));
        num_version.setCellValueFactory(new PropertyValueFactory<>("version"));
        set_name.setCellValueFactory(new PropertyValueFactory<>("SetName"));
        game_name.setCellValueFactory(new PropertyValueFactory<>("nomeGioco"));

        tableview.setItems(cards);
    }

    public void Expose(ActionEvent actionEvent) {

    }
}

