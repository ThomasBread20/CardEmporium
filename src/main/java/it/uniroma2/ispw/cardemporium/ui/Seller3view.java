package it.uniroma2.ispw.cardemporium.ui;



import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
            page.switchPage("venditore2", event);
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

    }

    @FXML
    void getQuantitiy(ActionEvent event) {

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
}

