package it.uniroma2.ispw.cardemporium.utility;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.ui.SwitchPageContr;

import java.io.IOException;

public class LogoutAction {

    public static void logout() throws ExceptionSwitchpage {
        String returnValue = Popup.logout();

        if(returnValue.equals("yes")){

            try {
                SwitchPageContr.getInstance().switchLogout(1);
            }catch (IOException e) {
                throw new ExceptionSwitchpage("switch page schermata registrazione Login View");
            }



        }

    }
    private LogoutAction() {}
}
