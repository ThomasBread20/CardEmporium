import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanY;
import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ExposeCardTest {

    //ExposeController exposeController=new ExposeController();
//GUIDATO SIMONE
    Float price= 1.1F;
    int quan=0;
    String lan="French";
    String cond="Good";
    int id=1;
    String nome="drago bianco";
    int v=1;
    String gioco="Yu-gi-oh";
    ExtraBeanY extraBeanY;
    String set="draghi della leggenda";
    CopiaCard card;
    @Test
    public void  searchTest() throws  ExceptionDBerror, IOException, ExceptionSwitchpage {

        try {
            ExposeController.ExposeOnMarketY(price,quan,lan,cond,id,nome,v,gioco,extraBeanY,set);
            Assertions.fail();
        } catch (Exceptionquantity e) {
            e.getMessage();
        }



        //non appena mettiamo le classi bean questo cerca una carta assurda e faccio assertion.fail()
    }
}
