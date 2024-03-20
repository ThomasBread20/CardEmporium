package it.uniroma2.ispw.cardemporium.ui;

import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeNonRegistrati extends Application {
    @Override
    public void start(Stage stage) throws IOException, ExceptionDBerror {

        Connection1Singelton.getInstance();
        SwitchPageContr.getInstance().switchPageContr1(stage);
        SwitchPageContr.getInstance().switchHomePage();
    }

    public static void main(String[] args) {
        launch();
    }


}