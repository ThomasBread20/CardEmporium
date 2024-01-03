package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.CardBean;
import it.uniroma2.ispw.cardemporium.bean.CardInfoBean;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanG;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanP;
import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.InsertCardController;
import it.uniroma2.ispw.cardemporium.exception.Exceptionquantity;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;
import it.uniroma2.ispw.cardemporium.model.Card;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExposeP implements Expose{

    CardBean cardBean=null;
    @Override
    public void expose(ObservableList<Card> card) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity;
        CardInfoBean cardInfoBean;
        String lan;

        Float price;
        int id = 0;
        int ver=0;
        String game=null;
        String set=null;
        String name=null;
        ExtraBeanP extraBeanP;
        for (Card card1 : card) {
            id=card1.getId();
            ver=card1.getVersion();
            name=card1.getName();
            set=card1.getSetName();
            game=card1.getNomegioco();
        }

        int choiceLan;
        try {
            CliPrinter.printMessage("Is your card a first edition? [y/n]");
            String r=reader.readLine();
            Boolean fed;
            if(r.equals("y")){
                fed=true;
            }
            else fed=false;


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
            CliPrinter.printMessage("Is your card a playset card? [y/n]");
            String t= reader.readLine();
            Boolean ps;
            if(t.equals("y")){
                ps=true;
            }else ps=false;

            CliPrinter.printMessage("Is your card a reverse holo card? [y/n]");
            Boolean rh;
            String q= reader.readLine();
            if(q.equals("y")){
                rh=true;
            }else rh=false;

            int choice;
            ExtraBeanG extraBeanG=new ExtraBeanG(al,si,fed,rh,ps);
            extraBeanP =new ExtraBeanP(id,name,ver,extraBeanG);

            String condition;
            choice= Expose.menu();
            condition=Expose.choiceCond(choice);
            cardBean=new CardBean(name,ver,game,set);
            choiceLan=Expose.menuLan();
            lan=Expose.choiceLang(choiceLan);
            CliPrinter.printMessage("Quantity: ");
            quantity= Integer.parseInt(reader.readLine());
            CliPrinter.printMessage("Price: ");
            price= Float.valueOf(reader.readLine());
            cardInfoBean=new CardInfoBean(id,cardBean,condition,price,quantity,extraBeanP,lan);
            InsertCardController.insertCardP(cardInfoBean);
            CliPrinter.printMessage("everything was fine");



        } catch (IOException | InvalidChioceException | Exceptionquantity e) {
            e.getMessage();
            CliPrinter.printMessage("something went wrong");
        }
    }
}
