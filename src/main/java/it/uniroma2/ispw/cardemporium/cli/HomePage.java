package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.business.DataSingleton;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;


import java.io.IOException;
import java.sql.SQLException;

public class HomePage extends CliManager {
    public void start() throws InvalidChioceException, IOException, ExceptionCardNotExist, SQLException, ExceptionDBerror {

        DataSingleton info = DataSingleton.getInstance();

        while(true){
            int choice=showMenu();
            switch (choice) {
                case 1:

                    new SearchcardPage().start();
                    break;

                case 2:
                    String role = info.getRole();
                    if (role.equals("Venditore")) {

                        CliPrinter.printMessage("bravo, sto ancora lavornado a sta roba, attendi stupido\n");


                    }else{
                        CliPrinter.printMessage("You are not a seller! Became a seller for sell your cards!\n");
                    }

                        break;
                case 3:
                    new Shoppingcart().start();

                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidChioceException("invalid choice");

            }

        }

    }

    public int showMenu(){
        CliPrinter.printMessage("what do you want to do?\n");
        CliPrinter.printMessage("1) Search a Card\n");
        CliPrinter.printMessage("2) Sell a card\n");
        CliPrinter.printMessage("3) View the Shopping Cart\n");
        CliPrinter.printMessage("4) Quit\n");
        return verifyChioce(1,4);
    }
}
