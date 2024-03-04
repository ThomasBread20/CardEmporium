package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.thomas.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;
import it.uniroma2.ispw.cardemporium.model.CardEntity;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SearchcardPage extends CliManager{
    public void start() throws InvalidChioceException, IOException, ExceptionCardNotExist, SQLException, ExceptionDBerror {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CliPrinter.printMessage("Type the Card name:\n");
        String name1 = reader.readLine();


        while (true) {
            try {

                ObservableList<CardEntity> cards = BuyCardApplicativo.searchCard(name1);
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
                        if (controllo(Integer.parseInt(name), cards)) {
                            CliPrinter.printMessage("do you want to add the " + name + " card? yes/no \n");
                            String name2 = reader.readLine();
                            if (name2.equals("yes")) {
                                BuyCardApplicativo carta = new BuyCardApplicativo();
                                carta.addCard(Integer.parseInt(name));
                            }

                        } else {
                            CliPrinter.printMessage("this card is not on the list\n");
                            CliPrinter.printMessage("please choose another card\n");
                        }

                        break;
                    case 2:
                        CliPrinter.printMessage("Type the Card name: \n");
                        name1 = reader.readLine();

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

    public void printCard(ObservableList<CardEntity> cards) throws ExceptionCardNotExist {




        CliPrinter.printMessage("ID - Condition  - seller - price  - language  - set   - extra\n");
        for(CardEntity item : cards){
            CliPrinter.printMessage(item.getCartaSingolaID() + "-" +item.getCondizione() + "-" + item.getUtenteVenditore()+ "-"  + item.getPrezzo() + "-" + item.getLingua() + "-" + item.getNomeSet() + "-"+ item.getExtra() + "\n");
        }
        CliPrinter.printMessage("\n");
    }

        public boolean controllo(int name, ObservableList<CardEntity> cards) throws ExceptionCardNotExist {
        for(CardEntity item : cards){
            if(name == item.getCartaSingolaID()){
                return true;
            }
        }

        return false;
    }
}
