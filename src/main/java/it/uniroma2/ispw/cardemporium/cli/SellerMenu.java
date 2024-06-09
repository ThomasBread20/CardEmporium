package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.utility.CliPrinter;
import it.uniroma2.ispw.cardemporium.exception.CardGameException;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;


import java.io.IOException;

import java.sql.SQLException;

public class SellerMenu extends CliManager{
    public void start(){

        while(true){
            int choice;
            choice=menu();
            try{
            switch (choice) {
                case 1:
                    new ExposeCardCli().start();
                    break;
                case 2:
                    new ManageCardCli().start();
                    break;
                case 3:

                    new HomePage().start();
                    break;
                case 4: System.exit(0);
                break;
                default: throw new InvalidChioceException("invalid choice");

            }
            break;
            } catch (InvalidChioceException | IOException | ExceptionCardNotExist | SQLException | ExceptionDBerror |
                     CardGameException e) {
                        e.getMessage();
            }
        }
    }


    public int menu(){

        CliPrinter.printMessage("1) Expose Cards");
        CliPrinter.printMessage("2) Manage Cards");
        CliPrinter.printMessage("3) Return to Home Page");
        CliPrinter.printMessage("4) Exit");
        return verifyChioce(1,4);
    }
}
