package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.model.Card;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private ChoiceBox<String> choiceSet;


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
    public Object verify_game(){
        Object str;
        Object r=choiseGame.getValue();
        if(r!=null){
          str=r;
        }else{
            str=null;
        }
        return str;

}
public Object verify_version(){
    Object n;
    Integer version=choiceVersion.getValue();
    if(version!=null){
        n=version;

    }else{
        n=0;
    }
    return n;
}
public Object verify_set() {
    Object str;
    Object r = choiceSet.getValue();
    if (r != null) {
        str = r;
    } else {
        str = null;
    }
    return str;


}



    @FXML
    void Continue(ActionEvent event) throws ExceptionDBerror, ExceptionCardNotExist, SQLException, ExceptionUserAlreadyExist, CardGameException, IOException {
        SwitchPage page = SwitchPage.getInstance();
        String game =ExposeController.getConcreteGame((String) verify_game());
        CardBean cardBean=new CardBean(nameTF.getText(), (Integer) verify_version(), (String) verify_game(),(String) verify_set());

        //CardBean cb = new CardBean(nameTF.getText(), (Integer) verify_version(), (String) verify_game(), (String) verify_set());
        try {
            //ObservableList<Card> cards =  ExposeController.SearchAllCard(nameTF.getText(), (Integer) verify_version(), (String) verify_game(), (String) verify_set());
            ObservableList<Card> cards=cardBean.showCard(event);
            //Object switchpage = page.switchPageseller(game, event);

            if(game=="yugioh") {
                YugiohView yu = (YugiohView) page.switchPageseller(game, event);
                yu.populate_table(cards);
            } else if (game=="poke") {
                pokemonView pv=(pokemonView)page.switchPageseller(game,event);
                pv.populate_table(cards);
            } else if (game=="dg") {
                dgView dgv=(dgView)page.switchPageseller(game,event);
                dgv.populate_table(cards);
            } else if (game=="magic") {
                magicView mv=(magicView) page.switchPageseller(game,event);
                mv.populate_table(cards);

            }

           // .populate_table(cards);


            /*
             cb.showCard(event);
             ObservableList<Card>card=ExposeController.SearchAllCard(nameTF.getText(), (Integer) verify_version(), (String) verify_game(), (String) verify_set());
             Seller3view seller3view= SwitchPage.switchPageseller("venditore3",event);
             seller3view.populate_table(card);*/
        } catch (ExceptionCardNotExist e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification!");
            alert.setHeaderText("This Card do not exist!");
            alert.showAndWait();
        } catch (ExceptionSwitchpage e) {
            throw new RuntimeException(e);
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
    public String[]set={
            "draghi della leggenda","battaglie della leggenda","fantasmi dal passato","sopravvissuti selvaggi","incredibili difensori","tempesta argentata","lucentezza siderale"
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceVersion.getItems().addAll(v);
        choiseGame.getItems().addAll(games);
        choiceSet.getItems().addAll(set);
    }

    public void ShoppingCart(ActionEvent event) throws ExceptionSwitchpage, ExceptionDBerror {

        SwitchPage page = SwitchPage.getInstance();


        try{

            ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());



            Carrelloview Carrelloview = page.switchPageData1("Schermata_Carrello", event);


            Carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}


