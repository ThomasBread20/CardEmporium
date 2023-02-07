package it.uniroma2.ispw.cardemporium.ui;
import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.controller.RegisterController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
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
import java.sql.SQLException;
import java.time.LocalDate;

import static java.lang.Thread.sleep;

public class RegisterView {

    @FXML
    private Text CardEmporiumT;

    @FXML
    private Label LabelError;

    @FXML
    private Text CognomeT;

    @FXML
    private TextField CognomeTextField;

    @FXML
    private Text DataNascitaT;


    @FXML
    private DatePicker DataNascitaTextField;

    @FXML
    private Line Linea1;

    @FXML
    private Line Linea2;

    @FXML
    private TextField NomeTextField;

    @FXML
    private Text PasswordT;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private Button RegistrarsiB;

    @FXML
    private Text RipetiPassT;

    @FXML
    private PasswordField RipetiPasswordTextField;

    @FXML
    private Button SchermataBaseB;

    @FXML
    private Text UserNameT;

    @FXML
    private TextField UsernameTextField;

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
    void DateField(ActionEvent event) {

    }

    @FXML
    void NameField(ActionEvent event) {

    }

    @FXML
    void PassField(ActionEvent event) {

    }

    @FXML
    void RepPassField(ActionEvent event) {

    }

    @FXML
    void SurField(ActionEvent event) {

    }


    @FXML
    void UsField(ActionEvent event) {

    }

    public void getDate(ActionEvent event){

        LocalDate myDate = DataNascitaTextField.getValue();
    }

    boolean CheckPassword(String pass1, String pass2){
        String FirstPass = pass1;
        String SecPass = pass2;

        if(FirstPass.compareTo(SecPass) != 0 ){
            RipetiPasswordTextField.clear();
            return false;
        }
        else{
            return true;
        }

    }

    public void RegisterButton(ActionEvent event) throws SQLException, IOException, InterruptedException {


        if (CheckPassword(PasswordTextField.getText(), RipetiPasswordTextField.getText())) {

            try {
                RegisterProcess(
                        UsernameTextField.getText(),
                        PasswordTextField.getText(),
                        NomeTextField.getText(),
                        CognomeTextField.getText(),
                        DataNascitaTextField.getValue());



                FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata login.fxml"));
                Parent ViewRegister = loader.load();
                Scene ViewRegisterScene = new Scene(ViewRegister);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                LoginView loginView = loader.getController();
                loginView.changeLabel("Register successfully complete! Switch To Login Page");
                window.setScene(ViewRegisterScene);
                window.show();

            } catch (ExceptionUserAlreadyExist e) {
                LabelError.setTextFill(Color.TOMATO);
                LabelError.setText("User already exist... Please try again");
            }
        } else{
            LabelError.setTextFill(Color.TOMATO);
            LabelError.setText("Wrong check-password... Please try again");
        }
    }
    public boolean RegisterProcess(String username, String passwd, String Name, String Surname, LocalDate Date) throws SQLException, ExceptionUserAlreadyExist {

        RegisterBean Register=new RegisterBean();
        Register.setUsernameBean(username);
        Register.setPasswdBean(passwd);
        Register.setNameBean(Name);
        Register.setCognomeBean(Surname);
        Register.setDateBean(Date);


        return RegisterController.insertUserDao(Register);

    }


    public void TornaLogin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("schermata login.fxml"));
        Parent ViewRegister = loader.load();

        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(ViewRegisterScene);
        window.show();
    }

    @FXML
    public void sitename(ActionEvent event) throws IOException{
        Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata home non registrato.fxml"));
        Scene ViewRegisterScene = new Scene(ViewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(ViewRegisterScene);
        window.show();

    }


}



