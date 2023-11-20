package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;

import java.util.Scanner;

public class CliManager {

    public int verifyChioce(int a,int b) {


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
}
