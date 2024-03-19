package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.business.LogoutAction;
import it.uniroma2.ispw.cardemporium.business.Popup;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;


import java.io.IOException;
import java.sql.SQLException;

public class Profiloview {

    @FXML
    private Button homeButtom;

    @FXML
    private Button logoutButton;

    @FXML
    private Label nome;

    @FXML
    private Button sellButton;

    @FXML
    private Label cognome;

    @FXML
    private Label datanascita;

    @FXML
    private Button profileButton;

    @FXML
    private TextField researchBar1;

    @FXML
    private Label ruolo;

    @FXML
    private Label username;

    @FXML
    private Button searchbuttom;

    DataSingleton info = DataSingleton.getInstance();

    @FXML
    private Button carrello;

    public void openCarrello(ActionEvent event) throws ExceptionSwitchpage, ExceptionDBerror {

        /*CardController view = new CardController();

        try{

            ObservableList<CarrelloEntity> cards =  view.searchCard1( view.getID());



            Carrelloview carrelloview = SwitchPage.switchPageShoppingCart("Schermata_Carrello", event);



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
        }*/

    }


    public void initData(String user, String name, String surname, String born, String role) {
        username.setText(user);
        nome.setText(name);
        cognome.setText(surname);
        datanascita.setText(born);
        ruolo.setText(role);
    }


    @FXML
    void search(ActionEvent event) throws SQLException, IOException, ExceptionSwitchpage {



       /* try{
            ObservableList<CardEntity> cards =  CardController.searchCard(researchBar1.getText());





            FXMLLoader loader = new FXMLLoader(getClass().getResource("Schermata_Carta.fxml"));
            Parent viewRegister = loader.load();
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            CardView cardView = loader.getController();



            cardView.initData1(cards.get(0).getNomeCarta(), cards.get(0).getNomeGioco());
            cardView.modifytable(cards);


            window.setScene(viewRegisterScene);
            window.show();




        }catch (ExceptionCardNotExist e)
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification!");
            alert.setHeaderText("This Card do not exist!");
            alert.showAndWait();

        }catch ( IOException e) {
            throw new ExceptionSwitchpage("switch page Schermata_Carta Login View");
        }
*/

    }




    @FXML
    void sell(ActionEvent event) throws  ExceptionSwitchpage {


        String role = info.getRole();

        Popup.notSeller(event, role);


    }

    @FXML
    void logout(ActionEvent event) throws  ExceptionSwitchpage {


        LogoutAction.logout(event);
    }

    public void sitename1(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata_home_registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

        }

}


