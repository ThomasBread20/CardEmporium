package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.controller.LoginController;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.users.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


import java.io.IOException;
import java.sql.SQLException;


public class LoginView {

    @FXML
    private Text errorMessage;
    @FXML
    private Pane loginPane;

    @FXML
    private TextField usernamefield;

    @FXML
    private Text cardemp;



    @FXML
    private Button iscrivitiB;

    @FXML
    private Line line;

    @FXML
    private Line line1;

    @FXML
    private Text login;

    @FXML
    private Button loginB;

    @FXML
    private Text password;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Button sitename;

    @FXML
    private Text text;

    @FXML
    private Text textiscriviti;

    @FXML
    private Text username;


    @FXML

    public void changeLabel(String name){

        errorMessage.setFill(Color.GREEN);
        errorMessage.setText(name);

    }



    @FXML
    void loginB(ActionEvent event) throws  ExceptionDBerror {

        login(usernamefield.getText(),passwordfield.getText(), event);

    }
    public void login(String username, String passwd, ActionEvent event) throws  ExceptionDBerror {
        LoginBean loginInfo = new LoginBean();
        loginInfo.setUsernameBean(username);
        loginInfo.setPasswdBean(passwd);
        LoginController loginController = new LoginController();
        try {


                Users user = loginController.login(loginInfo.getUsernameBean(), loginInfo.getPasswdBean());

            SwitchPage page = new SwitchPage();
                page.switchPage(user.getHomePage(), event);



        } catch (ExceptionUserNotExist e) {
            errorMessage.setFill(Color.TOMATO);
            errorMessage.setText("Enter Correct Username/Password");

        } catch (ExceptionBannedUser e) {
            errorMessage.setFill(Color.TOMATO);
            errorMessage.setText("This user is banned.");

        } catch (ExceptionDBerror | IOException | ExceptionSwitchpage e) {
            throw new ExceptionDBerror("value");



        } catch (SQLException | ExceptionCardNotExist e) {
            throw new ExceptionDBerror("error");
        }
    }



    @FXML
    public void registratiButton(ActionEvent event) throws ExceptionSwitchpage {



        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata registrazione", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }



    }

    @FXML
    public void sitename(ActionEvent event) throws  ExceptionSwitchpage {


        try {
            SwitchPage page = new SwitchPage();
            page.switchPage("schermata home non registrato", event);
        }catch (ExceptionSwitchpage | IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }



    }
}

