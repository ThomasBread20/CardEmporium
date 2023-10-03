package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HomeNonRegistrati extends Application {
    @Override
    public void start(Stage stage) throws IOException, ExceptionDBerror {

        Connection1Singelton.getInstance();


        FXMLLoader fxmlLoader = new FXMLLoader(HomeNonRegistrati.class.getResource("schermata home non registrato.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}