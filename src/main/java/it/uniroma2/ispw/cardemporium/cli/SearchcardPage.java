package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.thomas.CardInformationBean;
import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.thomas.CardController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class SearchcardPage extends CliManager{
    public void start() throws InvalidChioceException, IOException, ExceptionCardNotExist, SQLException, ExceptionDBerror {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CliPrinter.printMessage("Type the Card name:\n");
        String name1 = reader.readLine();
        CardInformationBean bean = new CardInformationBean();
        bean.setNomeCarta(name1);
        CardController controller = new CardController();

        while (true) {
            try {

                List<CardInformationBean> cards = controller.searchCard(bean);
                if(cards.isEmpty()){
                    CliPrinter.printMessage("no cards are avaiable with this name, return to home page \n");
                    new HomePage().start();
                }
                printCard(cards);

                int choice = showMenu();
                switch (choice) {
                    case 1:
                        CliPrinter.printMessage("whitch card do you want? (inster the Card ID)\n");
                        String name = reader.readLine();
                        int value = Integer.parseInt(name)-1;
                        if (controllo(Integer.parseInt(name), cards)) {
                            CliPrinter.printMessage("do you want to add the " + name + " card? yes/no \n");
                            String name2 = reader.readLine();
                            if (name2.equals("yes")) {
                                bean.cardInformationBeaninfo(cards.get(value).getNomeCarta(),cards.get(value).getCartaSingolaID(),cards.get(value).getiDvenditore(),cards.get(value).getUtenteVenditore(),cards.get(value).getPrezzo() );
                                bean.cardInformationBeaninfo2(cards.get(value).getCartaID(),cards.get(value).getNomeGioco(),cards.get(value).getNomeSet(),cards.get(value).getCondizione(),cards.get(value).getLingua(),cards.get(value).getVersione(),cards.get(value).getExtra());
                                bean.setVendutoAndCarrello(false , true);
                                controller.addCard(bean);
                            }

                        } else {
                            CliPrinter.printMessage("this card is not on the list\n");
                            CliPrinter.printMessage("please choose another card\n");
                        }

                        break;
                    case 2:

                        CliPrinter.printMessage("Type the Card name:\n");
                        bean.setNomeCarta(reader.readLine());
                        break;
                    case 3:
                        new HomePage().start();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        throw new InvalidChioceException("invalid choice");

                }
            }catch (ExceptionCardNotExist e){
                CliPrinter.printMessage("the card do not exist, retry\n");
                CliPrinter.printMessage("return to Home Page\n");
                new HomePage().start();
            }


        }
    }
    public int showMenu(){
        CliPrinter.printMessage("what do you want to do?\n");
        CliPrinter.printMessage("1) add a card to the shopping cart\n");
        CliPrinter.printMessage("2) search another card\n");
        CliPrinter.printMessage("3) return to home page\n");
        CliPrinter.printMessage("4) quit\n");


        return verifyChioce(1,4);
    }

    public void printCard(List<CardInformationBean> cards) throws ExceptionCardNotExist {


        int value = 1;

        CliPrinter.printMessage("ID - Condition  - seller - price  - language  - set   - extra\n");
        for(CardInformationBean item : cards){
            CliPrinter.printMessage(value + "-" +item.getCondizione() + "-" + item.getUtenteVenditore()+ "-"  + item.getPrezzo() + "-" + item.getLingua() + "-" + item.getNomeSet() + "-"+ item.getExtra() + "\n");
            value++;
        }
        CliPrinter.printMessage("\n");
    }

        public boolean controllo(int name, List<CardInformationBean> cards) throws ExceptionCardNotExist {

            if( name <= cards.size())
            {
                return true;
            }else{
                return false;
            }


    }
}
