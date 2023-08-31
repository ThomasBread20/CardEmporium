package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Seller2view  implements Initializable{

    @FXML
    public Text profileButton;





    @FXML
    private Button logoutButton;
    @FXML
    private Label ermessage;


    @FXML
    private Text profiloButton;




    @FXML
    private Button Back;

    @FXML
    private Button Continue;


    @FXML
    private Button Search;

    @FXML
    private Button goHome;


    @FXML
    private Button profile;


    @FXML
    void Continue(ActionEvent event) throws ExceptionDBerror {
        CardBean cb = new CardBean(nameTF.getText(), choiceVersion.getValue(), choiseGame.getValue(), setTF.getText());
        try {
            cb.showCard(event);
        } catch (ExceptionCardNotExist e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification!");
            alert.setHeaderText("This Card do not exist!");
            alert.showAndWait();
        } catch (ExceptionDBerror | IOException | ExceptionSwitchpage e) {
            throw new ExceptionDBerror("value");

        }
    }







    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout(event);
    }

    DataSingleton info = DataSingleton.getInstance();





    public void goHome(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", actionEvent);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata home");
        }
    }

    public void goProfile(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata_utenteProfilo.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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

    public void goback(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_venditore1", actionEvent);
        } catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata seller");
        }
    }

    @FXML
    private ChoiceBox<Integer> choiceVersion;

    @FXML
    private ChoiceBox<String> choiseGame;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField setTF;

    public String[]games={"Yu-gi-oh","Pokemon","Magic","Dragonball"};
    public Integer[]v={1,2,3};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceVersion.getItems().addAll(v);
        choiseGame.getItems().addAll(games);
    }


}


