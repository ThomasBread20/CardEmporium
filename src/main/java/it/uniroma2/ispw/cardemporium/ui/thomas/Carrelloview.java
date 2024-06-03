package it.uniroma2.ispw.cardemporium.ui.thomas;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.bean.thomas.CouponInformationBean;
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
import javafx.scene.text.Text;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Carrelloview {

    @FXML
    private Button homebutton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button sellbutton;

    @FXML
    private Button carrello;

    @FXML
    private TableView<CardInformationBean> tableView;


    @FXML
    private TableColumn<CardInformationBean, Integer> id;

    @FXML
    private TableColumn<CardInformationBean, String> nome;

    @FXML
    private TableColumn<CardInformationBean, Double> prezzo;
    @FXML
    private TableColumn<CardInformationBean, String> venditore;
    @FXML
    private TableColumn<CardInformationBean, String> extra;
    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;

    @FXML
    private ChoiceBox<String> coupon;

    @FXML
    private ChoiceBox<String> shipping;


    @FXML
    private Text prize;
    @FXML
    private Text prize1;
    @FXML
    private Text prize2;



    ObservableList<CardInformationBean> cards = FXCollections.observableArrayList();

    CouponInformationBean couponinfo = new CouponInformationBean();

    public void modifyChoiceBox()  {

            ShoppingController couponct = new ShoppingController();

            ObservableList<String> shippingType = FXCollections.observableArrayList(couponct.returnCouponorShipping(1));
            shipping.setItems(shippingType);
            prize.setText("0");
            prize2.setText("Select a shipping method:");



            List<String> couponList =  couponct.returnCouponorShipping(0);
            shipping.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newVaue) ->{
                couponinfo.setShipping(shipping.getValue());
                prize.setText(String.valueOf(couponct.returnShippingfromEntity(shipping.getValue())));
                update(couponList);
            } );
    }


    private void update(List<String> couponList){
        ShoppingController couponct = new ShoppingController();
        prize2.setText("");
        prize1.setText("Select a coupon:");
        ObservableList<String> coupons = FXCollections.observableArrayList(couponList);
        coupon.setItems(coupons);
        coupon.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newVaue) ->{
            couponinfo.setType(coupon.getValue());
            double prizeCouponvalue1 = 0;
            prizeCouponvalue1 = couponct.returnCouponfromEntity(couponinfo.getType());
            prize.setText(String.valueOf(prizeCouponvalue1));


        } );
    }

    public void buyAllCardIntoCart() throws  ExceptionSwitchpage {


        String returnValue = Popup.shoppingcart(2);
        CardInformationBean bean = new CardInformationBean();
        List<CardInformationBean> carte = translateObserveIntoList(cards);
        bean.setLista(carte);
        if(returnValue.equals("yes")){

            try{


                ShoppingController.shopping(bean, couponinfo);

                carte.clear();


                modifytable(carte);
            }catch(ExceptionDBerror e){
                e.getCause();
            }

        }

    }

    @FXML
    void homebutton(ActionEvent event) throws ExceptionSwitchpage {
        try {
            SwitchPageContr.getInstance().switchHomeRegisterPage();
        }catch (IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

    }



    @FXML
    void logout() throws ExceptionSwitchpage {


        LogoutAction.logout();
    }

    @FXML
    void searchCard(ActionEvent event) throws SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage{
        CardController view = new CardController();
        CardInformationBean bean = new CardInformationBean();
        try{
            cards.removeAll();
            bean.setNomeCarta(researchBar.getText());
            bean.setLista(view.searchCard(bean));
            SwitchPageContr.getInstance().switchCardView(bean);
        }catch (ExceptionCardNotExist e)
        {
            Popup.cardNoExist();
        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


    }
    public void modifytable(List<CardInformationBean> carrello){


        tableView.getItems().clear();

        cards = translateListINtoObserve(carrello);


        id.setCellValueFactory(new PropertyValueFactory<>("cartaSingolaID"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nomeCarta"));
        prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        venditore.setCellValueFactory(new PropertyValueFactory<>("UtenteVenditore"));
        extra.setCellValueFactory(new PropertyValueFactory<>("extra"));


        tableView.setItems(cards);

        modifyChoiceBox();


    }

    public List<CardInformationBean> translateObserveIntoList(ObservableList<CardInformationBean> cards)
    {
        List<CardInformationBean> listaCarte = new ArrayList<>();
        for(int value = 0; value < cards.size(); value++){
            listaCarte.add(cards.get(value));
        }
        return listaCarte;
    }


    public ObservableList<CardInformationBean> translateListINtoObserve(List<CardInformationBean> cards)
    {
        ObservableList<CardInformationBean> listaCarte = FXCollections.observableArrayList();
        for(int value = 0; value < cards.size(); value++){
            listaCarte.add(cards.get(value));
        }
        return listaCarte;
    }

    @FXML
    void sell(ActionEvent event) throws ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);



    }


    DataSingleton info = DataSingleton.getInstance();
    @FXML
    void profileButton(ActionEvent event) throws IOException {
        //profilo
    }




    public void openCarrello() throws ExceptionSwitchpage, ExceptionDBerror, ExceptionCardNotExist, SQLException, IOException {
        CardInformationBean bean = new CardInformationBean();
        try{


            ShoppingController carta =  new ShoppingController();

            bean.setLista(carta.getListofcardIntoShoppingCart());
            SwitchPageContr.getInstance().switchCarrelo(bean);



        }catch (ExceptionCardNotExist | IOException e) {

            throw new ExceptionSwitchpage("switch page Carrello");


        }catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("DBerror");


        } catch (SQLException e) {
            e.getErrorCode();
        }
    }



    public void removeCardFromCart() throws ExceptionSwitchpage, ExceptionCardNotExist {

        int index = tableView.getSelectionModel().getSelectedIndex();
        CardInformationBean bean = new CardInformationBean();


        if(index <= -1){
            return;
        }
        bean.setCartaSingolaID(id.getCellData(index));
        String returnValue = Popup.shoppingcart(1);

        if(returnValue.equals("yes")){


            try{
                ShoppingController carta = new ShoppingController();
                List<CardInformationBean> card = carta.removeCard(bean, index);
                modifytable(card);

            }catch(ExceptionDBerror e){
                e.getCause();
            }
        }
    }




}

