package it.uniroma2.ispw.cardemporium.ui.thomas;




import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.thomas.CardController;
import it.uniroma2.ispw.cardemporium.controller.thomas.ShoppingController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.ui.SwitchPageContr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardView {

    @FXML
    private Button logoutButton;

    @FXML
    private Label nome;

    @FXML
    private Button sellButton;

    @FXML
    private TableView<CardInformationBean> tableList;

    @FXML
    private TableColumn<CardInformationBean,String> condizione;

    @FXML
    private TableColumn<CardInformationBean, Integer> id;
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
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button homeButton1;

    @FXML
    private Button searchbuttom;

    @FXML
    private Button carrello;

    ObservableList<CardInformationBean> cards = FXCollections.observableArrayList();

    public void openCarrello(ActionEvent event) throws ExceptionSwitchpage, ExceptionDBerror {

        CardInformationBean bean = new CardInformationBean();
        try{


            ShoppingController carta =  new ShoppingController();



            bean.setLista(carta.getListofcardIntoShoppingCart());
            SwitchPageContr.getInstance().SwitchCarrelo(bean);





        }catch (ExceptionCardNotExist | IOException e) {

            throw new ExceptionSwitchpage("switch page Carrello");


        }catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("DBerror");


        } catch (SQLException e) {
            e.getErrorCode();
        }

    }




    @FXML
    void  homeButton1(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPageContr.getInstance().SwitchHomeRegisterPage();
        }catch (IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }
    }

    @FXML
    void searchCard(ActionEvent event) throws SQLException,ExceptionSwitchpage {
        CardController view = new CardController();
        CardInformationBean bean = new CardInformationBean();
        try{
            cards.removeAll();
            bean.setNomeCarta(researchBar.getText());
            List<CardInformationBean> listCard = view.searchCard(bean);
            bean.setLista(listCard);
            SwitchPageContr.getInstance().SwitchCardView(bean);
        }catch (ExceptionCardNotExist e)
        {
            Popup.cardNoExist();
        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }

    }

    Integer index;



    DataSingleton info = DataSingleton.getInstance();




    @FXML
    void logout(ActionEvent event) throws ExceptionSwitchpage {
        LogoutAction.logout();

    }

    @FXML
    void sell(ActionEvent event) throws ExceptionSwitchpage {

        String role = info.getRole();

        Popup.notSeller(event, role);


    }

    @FXML
    void profileButton(ActionEvent event) throws IOException {

    }


    public void initData1(String name, String gioco1) {
        //spostare questa cosa su un controller

        nome.setText(name);
        gioco.setText(gioco1);

    }



    public void modifytable(List<CardInformationBean> listaCarte){

        tableList.getItems().clear();

        cards = translateListINtoObserve(listaCarte);
        id.setCellValueFactory(new PropertyValueFactory<>("cartaSingolaID"));
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




    public void putCardIntoCart(MouseEvent mouseEvent) throws ExceptionSwitchpage {

        List<CardInformationBean> carte = new ArrayList<CardInformationBean>();
        CardController card =  new CardController();

        index = tableList.getSelectionModel().getSelectedIndex();

        if(index <= -1){
            return;
        }

        String returnValue = Popup.shoppingcart(1);

        if(returnValue.equals("yes")){

            try{
                CardInformationBean infoCard = new CardInformationBean();
                CardController carta = new CardController();
                infoCard.cardInformationBeaninfo(cards.get(index).getNomeCarta(),cards.get(index).getCartaSingolaID(),cards.get(index).getiDvenditore(),cards.get(index).getUtenteVenditore(),cards.get(index).getPrezzo() );
                infoCard.cardInformationBeaninfo2(cards.get(index).getCartaID(),cards.get(index).getNomeGioco(),cards.get(index).getNomeSet(),cards.get(index).getCondizione(),cards.get(index).getLingua(),cards.get(index).getVersione(),cards.get(index).getExtra());
                infoCard.setVendutoAndCarrello(false , true);
                carta.addCard(infoCard);


                CardController view = new CardController();
                carte = view.searchCard(infoCard);
                modifytable(carte);

            }catch(ExceptionDBerror | SQLException e){
                e.getCause();

            } catch (ExceptionCardNotExist e) {
                carte.clear();
                modifytable(carte);

            }

        }

    }
}


