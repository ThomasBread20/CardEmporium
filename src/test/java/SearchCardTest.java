import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

 class SearchCardTest {


    String cardname = "topolino";


    @Test
    void searchTest() throws ExceptionDBerror, IOException, ExceptionSwitchpage {

        try {

            BuyCardApplicativo.searchCard(cardname);
            //ExposeController.exposeOnMarketY(cardInfoBean);
            Assertions.fail();
        } catch (ExceptionCardNotExist | SQLException e ) {
            e.getMessage();
        }

    }
}