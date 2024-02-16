package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.controller.BuyCardApplicativo;
import it.uniroma2.ispw.cardemporium.controller.ShoppingController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;
import it.uniroma2.ispw.cardemporium.model.CopiaCardCarrello;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
public class Shoppingcart extends CliManager {

    public void start() throws InvalidChioceException, IOException, ExceptionCardNotExist, SQLException, ExceptionDBerror {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataSingleton inf = DataSingleton.getInstance();
        BuyCardApplicativo carta = new BuyCardApplicativo();

        while(true){
            try{
                ObservableList<CopiaCardCarrello> cards =  carta.searchCard1( carta.getID());
                printCard(cards);
                int choice=showMenu();

            switch (choice) {
                case 1:
                    CliPrinter.printMessage("whitch card do you want to remove?\n");
                    String name1 = reader.readLine();
                    if(controllo(Integer.parseInt(name1), cards)){

                        carta.removeCard(Integer.parseInt(name1));
                    }else{
                        CliPrinter.printMessage("you do not have a card with this id in your shopping cart");
                        CliPrinter.printMessage("choose another card\n");
                    }

                    break;

                case 2:


                        int value = inf.getID();
                        while (!cards.isEmpty()) {
                            int n = 0;
                            CopiaCardCarrello carta1 = cards.get(n);


                            cards.remove(n);

                            ShoppingController.shopping(carta1.getCartaID(), value);
                            CliPrinter.printMessage("Congratulation, your the shopping has ended successfully \n");
                        }


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
            }catch(ExceptionDBerror e ){
                e.getMessage();
            }
        }

    }
    public int showMenu(){
        CliPrinter.printMessage("what do you want to do?\n");
        CliPrinter.printMessage("1) remove a card");
        CliPrinter.printMessage("2) shop all the cards");
        CliPrinter.printMessage("3) return to home page");
        CliPrinter.printMessage("4) quit\n");


        return verifyChioce(1,4);
    }

    public void printCard(ObservableList<CopiaCardCarrello> cards)  {




        CliPrinter.printMessage("ID ,Nome ,seller ,price  ,extra\n");
        for(CopiaCardCarrello item : cards){
            CliPrinter.printMessage(item.getCartaSingolaID() +  "-" + item.getNomeCarta() +  "-"+ item.getUtenteVenditore()+ "-"  + item.getPrezzo() +"-" + item.getExtra() );
        }
        CliPrinter.printMessage("\n");
    }
    public boolean controllo(int name, ObservableList<CopiaCardCarrello> cards)  {
        for(CopiaCardCarrello item : cards){
            if(name == item.getCartaSingolaID()){
                return true;
            }
        }

        return false;
    }
}

