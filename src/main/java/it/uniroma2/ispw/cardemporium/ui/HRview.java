package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;

public class HRview {



    @FXML
    private Button sellButton;

    @FXML
    private Button logoutButton;


    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;


    Stage stage;

    DataSingleton info = DataSingleton.getInstance();



    @FXML
    void logout(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {



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
    void sell(ActionEvent event) throws IOException, ExceptionSwitchpage {


        String role = info.getRole();

        if(role.equals("Venditore")){
            try {
                SwitchPage page = SwitchPage.getInstance();
                page.switchPage("schermata_venditore1", event);
            }catch (ExceptionSwitchpage | IOException e) {
                throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You are not a Seller!");
            alert.setHeaderText("Became a Seller for sell your cards!");
            alert.show();
        }






    }


}
