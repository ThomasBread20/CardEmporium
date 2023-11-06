package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.*;

import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;


import javafx.stage.Stage;



import java.io.IOException;
import java.sql.SQLException;


public class HomeRview {






    @FXML
    private Button LogoutButton;

    @FXML
    private Button SellButton;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar;

    @FXML
    private Button searchbuttom;
    @FXML
    private Button Carrello;

    @FXML
    void Scarrello(ActionEvent event) throws IOException, ExceptionSwitchpage, ExceptionDBerror {


         try{

            ObservableList<CopiaCardCarrello> cards =  BuyCardApplicativo.searchCard1( BuyCardApplicativo.getID());



            Carrelloview carrelloview = SwitchPage.switchPageData1("Schermata_Carrello", event);


            carrelloview.modifytable(cards);


        }catch (ExceptionCardNotExist e)
        {

            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View1");


        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }


        catch (ExceptionDBerror  e) {
            throw new ExceptionDBerror("value");


        } catch (SQLException e) {
             e.getErrorCode();
         }


    }



    @FXML
    void Search(ActionEvent event) throws SQLException, ExceptionDBerror, IOException, ExceptionSwitchpage {



       try{
           ObservableList<CopiaCard> cards =  BuyCardApplicativo.searchCard(researchBar.getText());



           CardView cardView =  SwitchPage.switchPageData("Schermata_Carta", event);

           cardView.initData1(cards.get(0).getNomeCarta(), cards.get(0).getNomeGioco());
           cardView.modifytable(cards);


       }catch (ExceptionCardNotExist e)
       {

           Popup.cardNoExist();

       }catch ( IOException e) {
           throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
       }


       catch (ExceptionDBerror  e) {
           throw new ExceptionDBerror("value");


       }


    }







    Stage stage;

    DataSingleton info = DataSingleton.getInstance();



    @FXML
    void Logout(ActionEvent event) throws  ExceptionSwitchpage {


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
    void Sell(ActionEvent event) throws  ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);






    }



}
