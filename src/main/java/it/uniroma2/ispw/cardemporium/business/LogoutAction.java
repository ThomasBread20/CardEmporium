package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LogoutAction {

    public static void logout(ActionEvent event) throws ExceptionSwitchpage {
        String returnValue = Popup.logout();

        if(returnValue.equals("yes")){

            try {
                SwitchPage page = SwitchPage.getInstance();
                page.switchPage("schermata login", event);
            }catch (ExceptionSwitchpage | IOException e) {
                throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
            }



        }

    }
    private LogoutAction() {}
}
