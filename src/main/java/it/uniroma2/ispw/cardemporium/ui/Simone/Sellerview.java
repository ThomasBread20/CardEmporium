package it.uniroma2.ispw.cardemporium.ui.Simone;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.ManageControllerApp;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.ui.Profiloview;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Sellerview {



    @FXML
    private Button homeRegistrat;

    @FXML
    private Button logoutButton;

    @FXML
    private Button profileButton;


    DataSingleton info = DataSingleton.getInstance();
    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    @FXML
    public void homeRegistrato(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }


    }




    public void profileButton(ActionEvent event) throws IOException {
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
    void expose(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPage page = SwitchPage.getInstance();
            page.switchPage("venditore2", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page seller 2");
        }

    }

    public void manage(ActionEvent event) throws ExceptionSwitchpage {
        try {

            ManageControllerApp app =  new ManageControllerApp();
            SwitchPage page = SwitchPage.getInstance();


            ObservableList<CardEntity>cards=app.showCards();
            ManageCardsView manageCardsView=page.switchPageMC("schermata_venditore_Visualizza_vendite", event);
            manageCardsView.modifyTable(cards);


        }catch (ExceptionSwitchpage e) {
            throw new ExceptionSwitchpage("switch page seller 2");
        }
    }
}
