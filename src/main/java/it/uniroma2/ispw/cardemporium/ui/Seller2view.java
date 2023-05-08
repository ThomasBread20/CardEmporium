package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.NameCardBean;
import it.uniroma2.ispw.cardemporium.bean.PriceBean;
import it.uniroma2.ispw.cardemporium.bean.QuantityBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class Seller2view {
    public Text profileButton;
    @FXML
    private Button sellCard;

        @FXML
        private TextField Price;

        @FXML
        private Button cardName;

        @FXML
        private Button logoutButton;

        @FXML
        private TextField number;

        @FXML
        private Text profiloButton;

        @FXML
        private TextField searchProduct;

        @FXML
        private TextArea textArea;
    private Label price;



    @FXML
        void cardName(ActionEvent event) {

        }

        @FXML
        void logout(ActionEvent event) throws ExceptionSwitchpage {
            LogoutAction.logout(event);
        }
    DataSingleton info = DataSingleton.getInstance();

        @FXML
        void number(ActionEvent event) {
            QuantityBean quantityBean = new QuantityBean();
            quantityBean.setQuantityBeanValue(Integer.valueOf(number.getText()));
        }

        @FXML
        void price(ActionEvent event) {
            PriceBean pb=new PriceBean();
            pb.setPriceBeanValue(Double.valueOf(Price.getText()));
        }




        @FXML
        void search(ActionEvent event) {
            NameCardBean nc=new NameCardBean();
            nc.setName(searchProduct.getText());
        }
    @FXML
    void sell(ActionEvent event) {

    }



    public void goHome(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", actionEvent);
        }catch (ExceptionSwitchpage | IOException e) {
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

    public void getCondition(ActionEvent actionEvent) {
    }

    public void getLanguage(ActionEvent actionEvent) {
    }

}


