import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SearchCardTest {

    //ExposeController exposeController=new ExposeController();
//GUIDATO SIMONE
    String nome="drago bia";
    String gioco="Yu-gi-oh";
    int version=1;
    String set="draghi della leggenda";
    @Test
    public void  searchTest() throws  ExceptionDBerror, IOException, ExceptionSwitchpage {
        CardBean cardBean=new CardBean(nome,version,gioco,set);
        ActionEvent event = null;
        try {

            cardBean.showCard(event);
        }catch(ExceptionCardNotExist e){
            e.getMessage();
        }

        Assertions.fail();

        //non appena mettiamo le classi bean questo cerca una carta assurda e faccio assertion.fail()
    }
}
