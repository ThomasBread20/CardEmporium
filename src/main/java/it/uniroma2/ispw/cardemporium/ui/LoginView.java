package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.controller.LoginController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.users.Users;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginView {

    @FXML
    private Pane loginPane;

    @FXML
    private TextField usernamefield;

    @FXML
    private Text cardemp;

    @FXML
    private Label errorMessage;

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
    void usernamefield(ActionEvent event) {
        throw new UnsupportedOperationException("");
    }

    public void changeLabel(String name){

        errorMessage.setTextFill(Color.GREEN);
        errorMessage.setText(name);

    }

    @FXML
    void changeScreenButtonPushed(ActionEvent event) {
        throw new UnsupportedOperationException("");
    }

    @FXML
    void loginB(ActionEvent event) throws SQLException, ExceptionDBerror {

        login(usernamefield.getText(),passwordfield.getText(), event);

    }
    public void login(String username, String passwd, ActionEvent event) throws SQLException, ExceptionDBerror {
        LoginBean loginInfo=new LoginBean();
        loginInfo.setUsernameBean(username);
        loginInfo.setPasswdBean(passwd);
        result(loginInfo, event);

    }

    public void result(LoginBean credential, ActionEvent event) throws ExceptionDBerror {
        try {
            Users user = LoginController.checkUserDao(credential);
            errorMessage.setTextFill(Color.GREEN);
            errorMessage.setText("Succesfull Login! Processing...");

            LoginController.DataFuller(user.getPwd(),user.getUsername(),user.getName(),user.getSurname(),user.getData(),user.getIsBanned(),user.getRole());

            Parent viewRegister = FXMLLoader.load(getClass().getResource(user.getHomePage() + ".fxml" ));
            Scene viewRegisterScene = new Scene(viewRegister);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(viewRegisterScene);
            window.show();

        } catch (ExceptionUserNotExist e) {
            errorMessage.setTextFill(Color.TOMATO);
            errorMessage.setText("Enter Correct Username/Password");

        } catch (ExceptionBannedUser e) {
            errorMessage.setTextFill(Color.TOMATO);
            errorMessage.setText("This user is banned.");
         
        } catch (IOException e) {
            throw new ExceptionDBerror("value");
        }
    }

    @FXML
    void passwordfield(ActionEvent event) {
        throw new UnsupportedOperationException("");
    }
    public void registratiButton(ActionEvent event) throws IOException {

        Parent viewRegister = FXMLLoader.load(getClass().getResource("schermata registrazione.fxml"));
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(viewRegisterScene);
        window.show();
    }

    @FXML
    public void sitename(ActionEvent event) throws IOException{
        Parent viewRegister = FXMLLoader.load(getClass().getResource("schermata home non registrato.fxml"));
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(viewRegisterScene);
        window.show();


    }


}
