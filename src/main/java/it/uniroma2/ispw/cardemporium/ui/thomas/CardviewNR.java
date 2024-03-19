package it.uniroma2.ispw.cardemporium.ui.thomas;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.thomas.CardController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import it.uniroma2.ispw.cardemporium.ui.SwitchPageContr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardviewNR {

    @FXML
    private Button buttomLogin;

    @FXML
    private Button buttomRegister;

    @FXML
    private Label nome;

    @FXML
    private TableView<CardInformationBean> tableList;



    @FXML
    private TableColumn<CardInformationBean,String> condizione;
    @FXML
    private TableColumn<CardInformationBean, String> lingua;

    @FXML
    private TableColumn<CardInformationBean, Double> prezzo;
    @FXML
    private TableColumn<CardInformationBean, String> venditore;

    @FXML
    private TableColumn<CardInformationBean, String> setgioco;

    @FXML
    private TableColumn<CardInformationBean, String> extra;

    @FXML
    private Label gioco;




    @FXML
    private TextField researchBar;


    @FXML
    private Text testoCard;

    @FXML
    private Button cardemporium;

    @FXML
    private Button searchbuttom;


    ObservableList<CardInformationBean> cards = FXCollections.observableArrayList();
    @FXML
    void searchCard(ActionEvent event) throws SQLException, ExceptionSwitchpage {
        CardController view = new CardController();
        CardInformationBean bean = new CardInformationBean();
        try{
            cards.removeAll();
            bean.setNomeCarta(researchBar.getText());
            List<CardInformationBean> listCard = view.searchCard(bean);
            bean.setLista(listCard);
            SwitchPageContr.getInstance().SwitchCardViewNR(bean);
        }catch (ExceptionCardNotExist e)
        {
            Popup.cardNoExist();
        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }



    }



    @FXML
    void homebutton(ActionEvent event) throws ExceptionSwitchpage {

        try {
            SwitchPageContr.getInstance().SwitchHomePage();
        }catch (IOException e) {
            throw new ExceptionSwitchpage("switch page schermata non registrazione Login View");
        }

    }


    @FXML
    public void login(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPageContr.getInstance().SwitchLogout(1);
        }catch (IOException e) {
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


    public void initData1(String name, String gioco1) {

        nome.setText(name);
        gioco.setText(gioco1);



    }



    public void modifytable(List<CardInformationBean> listaCarte){


        tableList.getItems().clear();

        CardInformationBean bean = new CardInformationBean();
        cards = translateListINtoObserve(listaCarte);


        condizione.setCellValueFactory(new PropertyValueFactory<>("condizione"));
        lingua.setCellValueFactory(new PropertyValueFactory<>("Lingua"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("UtenteVenditore"));
        setgioco.setCellValueFactory(new PropertyValueFactory<>("nomeSet"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));


        tableList.setItems(cards);
    }

    public List<CardInformationBean> translateObserveIntoList(ObservableList<CardInformationBean> cards)
    {
        List<CardInformationBean> listaCarte = new ArrayList<CardInformationBean>();
        for(int value = 0; value < cards.size(); value++){
            listaCarte.add(cards.get(value));
        }
        return listaCarte;
    }


    public ObservableList<CardInformationBean> translateListINtoObserve(List<CardInformationBean> cards)
    {
        ObservableList<CardInformationBean> listaCarte = FXCollections.observableArrayList();;
        for(int value = 0; value < cards.size(); value++){
            listaCarte.add(cards.get(value));
        }
        return listaCarte;
    }

}
