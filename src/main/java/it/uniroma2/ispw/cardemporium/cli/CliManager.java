package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.exception.CardGameException;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class CliManager {

    public static int verifyChioce(int a, int b) {


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            CliPrinter.printMessage("Please enter a choice: ");
            choice = input.nextInt();
            if (choice >= a && choice <= b) {
                break;
            }
        }
return choice;
    }

    public abstract void start() throws InvalidChioceException, IOException, SQLException, ExceptionDBerror, ExceptionCardNotExist, CardGameException;
}
