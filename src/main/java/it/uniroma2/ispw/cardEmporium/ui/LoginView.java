package it.uniroma2.ispw.cardEmporium.ui;

import it.uniroma2.ispw.cardEmporium.Bean.LoginBean;
import it.uniroma2.ispw.cardEmporium.Bean.RegisterBean;
import it.uniroma2.ispw.cardEmporium.Controller.LoginController;
import it.uniroma2.ispw.cardEmporium.Controller.ScreenController;
import it.uniroma2.ispw.cardEmporium.Users.Users;
import it.uniroma2.ispw.cardEmporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardEmporium.exception.ExceptionUserNotExist;
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
    private Pane Login;

    @FXML
    private TextField Usernamefield;

    @FXML
    private Text cardemp;

    @FXML
    private Label ErrorMessage;

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
    void Usernamefield(ActionEvent event) {

    }

    public void ChangeLabel(String name){

        ErrorMessage.setTextFill(Color.GREEN);
        ErrorMessage.setText(name);

    }

    @FXML
    void changeScreenButtonPushed(ActionEvent event) {

    }

    @FXML
    void loginB(ActionEvent event) throws SQLException {

        login(Usernamefield.getText(),passwordfield.getText(), event);

    }
    public void login(String username, String passwd, ActionEvent event) throws SQLException {
        LoginBean login=new LoginBean();
        login.setUsernameBean(username);
        login.setPasswdBean(passwd);
        Result(login, event);

    }

    public void Result(LoginBean credential,ActionEvent event) {
        try {
            Users user = LoginController.checkUserDao(credential);
            ErrorMessage.setTextFill(Color.GREEN);
            ErrorMessage.setText("Succesfull Login! Processing...");

            LoginController.DataFuller(user.getPwd(),user.getUsername(),user.getName(),user.getSurname(),user.getData(),user.getIsBanned(),user.getRole());

            Parent ViewRegister = FXMLLoader.load(getClass().getResource(user.getHomePage() + ".fxml" ));
            Scene ViewRegisterScene = new Scene(ViewRegister);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(ViewRegisterScene);
            window.show();

        } catch (ExceptionUserNotExist e) {
            ErrorMessage.setTextFill(Color.TOMATO);
            ErrorMessage.setText("Enter Correct Username/Password");
            return;
        } catch (ExceptionBannedUser e) {
            ErrorMessage.setTextFill(Color.TOMATO);
            ErrorMessage.setText("This user is banned.");
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void passwordfield(ActionEvent event) {

    }
    public void RegistratiButton(ActionEvent event) throws IOException {

        Parent ViewRegister = FXMLLoader.load(getClass().getResource("schermata registrazione.fxml"));
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
