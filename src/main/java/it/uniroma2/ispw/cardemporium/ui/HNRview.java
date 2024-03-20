package it.uniroma2.ispw.cardemporium.ui;


import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.thomas.CardController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HNRview {

    @FXML
    private Pane base;

    @FXML
    private Button buttomLogin;

    @FXML
    private Button buttomRegister;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;

    @FXML
    private Text testoCard;




    @FXML
    void search(ActionEvent event) throws SQLException,ExceptionDBerror, ExceptionSwitchpage {
        CardController view = new CardController();
        CardInformationBean bean = new CardInformationBean();
        try{
            bean.setNomeCarta(researchBar.getText());
            List<CardInformationBean> listCard = view.searchCard(bean);
            bean.setLista(listCard);
            SwitchPageContr.getInstance().switchCardViewNR(bean);
        }catch (ExceptionCardNotExist e)
        {
            Popup.cardNoExist();
        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


    }


    @FXML
    public void login(ActionEvent event) throws IOException, ExceptionSwitchpage {


        try {

            SwitchPage page = new SwitchPage();
            page.switchPage("schermataLogin", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }
    }

    @FXML
    public void register(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata registrazione", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }




    }

}

