package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.utility.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.LoginController;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginCli extends CliManager {

    public void start() throws InvalidChioceException, IOException, SQLException, ExceptionDBerror, ExceptionCardNotExist {
        while (true) {
            int choice;
            try {

                choice = menu();
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        new SignUpCli().start();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        throw new InvalidChioceException("invalid choice");
                }
                break;
            } catch (InvalidChioceException | IllegalStateException e) {
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





    public void login()  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LoginBean loginBean=new LoginBean();
        Logger logger=Logger.getLogger(LoginCli.class.getName());
        LoginController login =  new LoginController();
        try {
            CliPrinter.printMessage("Username:");
            String us=reader.readLine();
            loginBean.setUsernameBean(us);
            CliPrinter.printMessage("Password:");

            String pwd=reader.readLine();
            loginBean.setPasswdBean(pwd);
            login.login(us, pwd);



            new HomePage().start();


        } catch (IOException | ExceptionDBerror | ExceptionCardNotExist | SQLException | InvalidChioceException e) {
            e.getMessage();
        } catch (ExceptionUserNotExist e) {

            CliPrinter.printMessage("User don't exists");
            e.getMessage();
        }  catch (ExceptionBannedUser e) {
            e.getMessage();
            logger.log(Level.INFO,"Banned user");

        }
    }
}
