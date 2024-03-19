package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import it.uniroma2.ispw.cardemporium.ui.thomas.CardView;
import it.uniroma2.ispw.cardemporium.ui.thomas.CardviewNR;
import it.uniroma2.ispw.cardemporium.ui.thomas.Carrelloview;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SwitchPageContr {

        private Stage stage;

        public void SwitchPageContr1(Stage primaryStage){
            this.stage = primaryStage;
            primaryStage.show();
        }

        private static SwitchPageContr instance = null;

        public static SwitchPageContr getInstance(){
            if(instance==null){
            instance= new SwitchPageContr();
            }
            return instance;
        }

        enum Pages {
            CARTPAGE,
            HOMEPAGE
        };



        public void switchPage(Pages pageToSwitch) throws IOException {
            FXMLLoader loader = new FXMLLoader(FXMLLoader.class.getResource(pageToSwitch.name()));
            Parent viewRegister = loader.load();
            Scene scene = new Scene(viewRegister);
            stage.setScene(scene);
            stage.show();
        }
        public void SwitchCarrelo( CardInformationBean bean) throws IOException, SQLException, ExceptionDBerror {
            List<CardInformationBean> copiaCard = bean.getLista();
            FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("Schermata_Carrello.fxml"));
            Parent viewRegister = loader.load();
            Carrelloview carrelloview = loader.getController();
            carrelloview.modifytable(copiaCard);
            Scene viewRegisterScene = new Scene(viewRegister);
            stage.setScene(viewRegisterScene);
            stage.setTitle("ShoppingCart");
            stage.show();
        }

    public void SwitchCardView( CardInformationBean bean) throws IOException {
        FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("Schermata_Carta.fxml"));
        Parent viewRegister = loader.load();
        CardView cardView = loader.getController();
        List<CardInformationBean> cards = bean.getLista();
        cardView.initData1(cards.get(0).getNomeCarta(), cards.get(0).getNomeGioco());
        cardView.modifytable(cards);
        Scene viewRegisterScene = new Scene(viewRegister);
        stage.setScene(viewRegisterScene);
        stage.setTitle("CardView");
        stage.show();
    }


    public void SwitchHomePage() throws IOException {


        FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("schermata home non registrato.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);
        stage.setScene(viewRegisterScene);
        stage.setTitle("Home Page");
        stage.show();

    }

    public void SwitchHomeRegisterPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("Schermata_home_registrato.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);
        stage.setScene(viewRegisterScene);
        stage.setTitle("Home Page");
        stage.show();
    }
    public void SwitchLogout(int i) throws IOException {
        if(i == 1){
            FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("schermataLogin.fxml"));
            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);
            stage.setScene(viewRegisterScene);
            stage.setTitle("Login");
            stage.show();
        }else{
            FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("schermataLogin.fxml"));
            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);
            LoginView loginView = loader.getController();
            loginView.changeLabel("Register successfully complete! Switch To Login Page");
            stage.setScene(viewRegisterScene);
            stage.setTitle("Login");
            stage.show();
        }

    }


    public void SwitchCardViewNR( CardInformationBean bean) throws IOException {
        FXMLLoader loader = new FXMLLoader(SwitchPageContr.class.getResource("schermata_cartaNR.fxml"));
        Parent viewRegister = loader.load();
        CardviewNR cardView = loader.getController();
        List<CardInformationBean> cards = bean.getLista();
        cardView.initData1(cards.get(0).getNomeCarta(), cards.get(0).getNomeGioco());
        cardView.modifytable( cards);
        Scene viewRegisterScene = new Scene(viewRegister);
        stage.setScene(viewRegisterScene);
        stage.setTitle("CardView");
        stage.show();

    }





}
