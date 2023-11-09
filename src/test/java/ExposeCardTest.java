
import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanY;
import it.uniroma2.ispw.cardemporium.controller.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

 class ExposeCardTest {

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
    CardInfoBean cardInfoBean=new CardInfoBean(id,new CardBean(nome,v,gioco,set),cond,price,quan,extraBeanY,lan);
    @Test
    void  searchTest() throws  ExceptionDBerror, IOException, ExceptionSwitchpage {

        try {
            ExposeController.exposeOnMarketY(cardInfoBean);
            Assertions.fail();
        } catch (Exceptionquantity e) {
            e.getMessage();
        }



        //non appena mettiamo le classi bean questo cerca una carta assurda e faccio assertion.fail()
    }
}
