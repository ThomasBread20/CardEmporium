package it.uniroma2.ispw.cardemporium.ui.simone;

import it.uniroma2.ispw.cardemporium.bean.simone.CardBean;
import it.uniroma2.ispw.cardemporium.utility.DataSingleton;
import it.uniroma2.ispw.cardemporium.utility.LogoutAction;
import it.uniroma2.ispw.cardemporium.controller.simone.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.model.simone.Card;
import it.uniroma2.ispw.cardemporium.ui.Profiloview;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
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
    private Button goHome;


    @FXML
    private Button profile;
    public Object verifyGame(){
        Object str;
        Object r=choiseGame.getValue();
        if(r!=null){
          str=r;
        }else{
            str=null;
        }
        return str;

}
public Object verifyVersion(){
    Object n;
    Integer version=choiceVersion.getValue();
    if(version!=null){
        n=version;

    }else{
        n=0;
    }
    return n;
}
public Object verifySet() {
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
    void submit(ActionEvent event) throws ExceptionDBerror  {
        ExposeController exposeController=new ExposeController();
        exposeController.getConcreteGame((String) verifyGame());

        CardBean cardBean=new CardBean(nameTF.getText(), (Integer) verifyVersion(), (String) verifyGame(),(String) verifySet());
        ObservableList<Card> obcard;
        try {



                obcard = exposeController.searchAllCard(cardBean);
                if (cardBean.getGameBean().equals("Yu-gi-oh")) {
                    YugiohView yu = (YugiohView) SwitchPage.switchPageseller(cardBean.getGameBean(), event);
                    yu.populateTable(obcard);
                } else if (cardBean.getGameBean().equals("Pokemon")) {
                    PokemonView pv = (PokemonView) SwitchPage.switchPageseller(cardBean.getGameBean(), event);
                    pv.populateTable(obcard);
                } else if (cardBean.getGameBean().equals("dg")) {
                    Dgview dgv = (Dgview) SwitchPage.switchPageseller(cardBean.getGameBean(), event);
                    dgv.populateTable(obcard);
                } else if (cardBean.getGameBean().equals("Magic")) {
                    MagicView mv = (MagicView) SwitchPage.switchPageseller(cardBean.getGameBean(), event);
                    mv.populateTable(obcard);
                }





        } catch (ExceptionSwitchpage |ExceptionCardNotExist |SQLException e) {
            e.getCause();
        }

    }







    @FXML
    void logout() throws ExceptionSwitchpage {


        LogoutAction.logout();
    }
    DataSingleton info = DataSingleton.getInstance();





    public void goHome(ActionEvent actionEvent) throws ExceptionSwitchpage {
        try {
            SwitchPage page = new SwitchPage();
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
            SwitchPage page = new SwitchPage();
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

    public final String[]games={"Yu-gi-oh","Pokemon","Magic","Dragonball"};
    public final Integer[]v={1,2,3};
    public final String[]set={
            "draghi della leggenda","battaglie della leggenda","fantasmi dal passato","sopravvissuti selvaggi","incredibili difensori","tempesta argentata","lucentezza siderale"
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceVersion.getItems().addAll(v);
        choiseGame.getItems().addAll(games);
        choiceSet.getItems().addAll(set);
    }



}


