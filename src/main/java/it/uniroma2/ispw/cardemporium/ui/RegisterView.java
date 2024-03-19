package it.uniroma2.ispw.cardemporium.ui;
import it.uniroma2.ispw.cardemporium.bean.RegisterBean;

import it.uniroma2.ispw.cardemporium.controller.RegisterController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;
import it.uniroma2.ispw.cardemporium.exception.UnsupportedOperationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;




public class RegisterView {

    @FXML
    private Text cardEmporiumT;

    @FXML
    private Label labelError;

    @FXML
    private Text cognomeT;

    @FXML
    private TextField cognomeTextField;

    @FXML
    private Text dataNascitaT;


    @FXML
    private DatePicker dataNascitaTextField;

    @FXML
    private Line linea1;

    @FXML
    private Line linea2;

    @FXML
    private TextField nomeTextField;

    @FXML
    private Text passwordT;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registrarsiB;

    @FXML
    private Text ripetiPassT;

    @FXML
    private PasswordField ripetiPasswordTextField;

    @FXML
    private Button schermataBaseB;

    @FXML
    private Text userNameT;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button iscrivitiB;

    @FXML
    private Text nomeT;

    @FXML
    private Pane register;

    @FXML
    private Text registrazioneT;

    @FXML
    private Rectangle sfondo;

    @FXML
    private Text text;

    @FXML
    private Text textiscriviti;

    @FXML
    void dateField(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");

    }

    @FXML
    void nameField(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");
    }

    @FXML
    void passField(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");
    }

    @FXML
    void repPassField(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");
    }

    @FXML
    void surField(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");
    }


    @FXML
    void usField(ActionEvent event) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("");
    }


    boolean checkPassword(String pass1, String pass2){

        if(pass1.compareTo(pass2) != 0 ){
            ripetiPasswordTextField.clear();
            return false;
        }
        else{
            return true;
        }

    }

    public void registerButton(ActionEvent event) throws IOException, IllegalStateException {

        RegisterController registerController = new RegisterController();
        if (checkPassword(passwordTextField.getText(), ripetiPasswordTextField.getText())) {

            try {

                RegisterBean registerValue=new RegisterBean();
                registerValue.setUsernameBean( usernameTextField.getText());
                registerValue.setPasswdBean(passwordTextField.getText());
                registerValue.setNameBean(nomeTextField.getText());
                registerValue.setCognomeBean(cognomeTextField.getText());
                registerValue.setDateBean(dataNascitaTextField.getValue());



                registerController.insertUserDao(registerValue);


                SwitchPageContr.getInstance().SwitchLogout(2);
            } catch (ExceptionUserAlreadyExist e) {
                labelError.setTextFill(Color.TOMATO);
                labelError.setText("User already exist... Please try again");
            }
        } else{
            labelError.setTextFill(Color.TOMATO);
            labelError.setText("Wrong check-password... Please try again");
        }
    }


    //switch page
    public void tornaLogin(ActionEvent event) throws IOException, ExceptionSwitchpage {

        try {
           SwitchPageContr.getInstance().SwitchLogout(1);
        }catch (IOException e) {
            throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
        }

    }

    @FXML//switch page
    public void sitename(ActionEvent event) throws  ExceptionSwitchpage {
        try {
            SwitchPageContr.getInstance().SwitchHomePage();
        }catch (IOException e) {
            throw new ExceptionSwitchpage("switch page schermata non registrazione Login View");
        }




    }


}



