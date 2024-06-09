import it.uniroma2.ispw.cardemporium.utility.Popup;

import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserNotSellerTest {
    String user = "Utente";
    @Test
    void NotSeller(){

        ActionEvent event = null;
        try {
            Popup.notSeller(event, user);
            Assertions.fail();

        } catch (ExceptionSwitchpage e) {
            e.getMessage();
        }
    }
}
