package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;

import java.util.logging.Logger;

public class LoginCli extends CliManager {
    Logger logger=Logger.getLogger(LoginCli.class.getName());

    public void start() throws Exception {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    login();
                case 2:
                    new SignUpCli();
                case 3:
                    System.exit(0);
                default:
                    throw new Exception();
            }

        }
    }


    public int menu(){

        CliPrinter.printMessage("Welcome in the CardEmporium Dashboard"+"\n"+"1) Login"+"\n"+"2) Sign Up"+"\n"+"3) Exit"+"\n");
        int choice=verifyChioce(1,3);
        return choice;
        }





    public void login(){}
}
