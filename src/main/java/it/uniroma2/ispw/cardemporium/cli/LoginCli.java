package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.exception.*;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginCli extends CliManager {
ActionEvent event;
    public void start() throws Exception {
        while (true) {
            int choice;
            try {

                choice = menu();
                switch (choice) {
                    case 1:
                        login(event);
                        break;
                    case 2:
                        new SignUpCli();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        throw new InvalidChioceException("invalid choice");
                }
            } catch (InvalidChioceException e) {
                e.getMessage();
            }
        }
    }


    public int menu(){

        CliPrinter.printMessage("Welcome in the CardEmporium Dashboard");
        CliPrinter.printMessage("1) Login");
        CliPrinter.printMessage("2) Sign Up");
        CliPrinter.printMessage("3) Exit");
        return verifyChioce(1,3);

        }





    public void login(ActionEvent event) throws ExceptionSwitchpage {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LoginBean loginBean=new LoginBean();
        Logger logger=Logger.getLogger(LoginCli.class.getName());
        try {
            CliPrinter.printMessage("Username:");
            String us=reader.readLine();
            loginBean.setPasswdBean(us);
            CliPrinter.printMessage("Password:");

            String pwd=reader.readLine();
            loginBean.setPasswdBean(pwd);
            loginBean.result(event);
        } catch (IOException | ExceptionDBerror e) {
            e.getMessage();
        } catch (ExceptionUserNotExist e) {

            logger.log(Level.INFO,"User don't exists");
        }  catch (ExceptionBannedUser e) {
            e.getMessage();
            logger.log(Level.INFO,"Banned user");

        }
    }
}
