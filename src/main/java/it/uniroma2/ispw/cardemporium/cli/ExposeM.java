package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanM;
import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.InsertCardController;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;
import it.uniroma2.ispw.cardemporium.model.Card;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExposeM implements Expose{
    CardBean cardBean=null;
    @Override
    public void expose(ObservableList<Card> card) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity;
        CardInfoBean cardInfoBean;
        String lan;
        ExtraBeanM extraBeanM;
        Float price;
        int id = 0;
        int ver=0;
        String game=null;
        String set=null;
        String name=null;

        for (Card card1 : card) {
            id=card1.getId();
            ver=card1.getVersion();
            name=card1.getName();
            set=card1.getSetName();
            game=card1.getNomegioco();
        }

        int choiceLan;
        try {

            CliPrinter.printMessage("Is your card an altered card? [y/n]");
            String m=reader.readLine();
            Boolean al;
            if(m.equals("y")){
                al=true;
            }
            else al=false;
            CliPrinter.printMessage("Is your card a signed card? [y/n]");
            Boolean si;
            String s=reader.readLine();
            if(s.equals("y")){
                si=true;
            }
            else si=false;
            CliPrinter.printMessage("Is your card a foil card? [y/n]");
            String t= reader.readLine();
            Boolean foil;
            if(t.equals("y")){
                foil=true;
            }else foil=false;
            CliPrinter.printMessage("Is your card a playset card? [y/n]");
            String q= reader.readLine();
            Boolean ps;
            if(q.equals("y")){
                ps=true;
            }else ps=false;

            int choice;

            extraBeanM=new ExtraBeanM(si,al,foil,ps,id,ver,name);
            InsertCardController insertCardController=new InsertCardController();
            String condition;
            choice=Expose.menu();
            condition=Expose.choiceCond(choice);
            cardBean=new CardBean(name,ver,game,set);
            choiceLan=Expose.menuLan();
            lan=Expose.choiceLang(choiceLan);
            CliPrinter.printMessage("Quantity: ");
            quantity= Integer.parseInt(reader.readLine());
            CliPrinter.printMessage("Price: ");
            price= Float.valueOf(reader.readLine());
            cardInfoBean=new CardInfoBean(id,cardBean,condition,price,quantity,extraBeanM,lan);
            insertCardController.insertCardM(cardInfoBean);
            CliPrinter.printMessage("everything was fine");



        } catch (IOException | InvalidChioceException | Exceptionquantity e) {
            e.getMessage();
            CliPrinter.printMessage("something went wrong");
        }

    }
}
