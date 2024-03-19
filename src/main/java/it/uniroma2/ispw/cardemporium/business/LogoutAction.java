package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import it.uniroma2.ispw.cardemporium.ui.SwitchPageContr;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LogoutAction {

    public static void logout() throws ExceptionSwitchpage {
        String returnValue = Popup.logout();

        if(returnValue.equals("yes")){

            try {
                SwitchPageContr.getInstance().SwitchLogout(1);
            }catch (IOException e) {
                throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
            }



        }

    }
    private LogoutAction() {}
}
