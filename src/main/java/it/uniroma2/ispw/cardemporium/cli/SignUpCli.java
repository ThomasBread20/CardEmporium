package it.uniroma2.ispw.cardemporium.cli;


import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.business.CliPrinter;

import it.uniroma2.ispw.cardemporium.controller.RegisterController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionCardNotExist;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import it.uniroma2.ispw.cardemporium.exception.IllegalStateException;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class SignUpCli extends CliManager{
    @Override
    public void start() throws InvalidChioceException, IOException, SQLException, ExceptionDBerror, ExceptionCardNotExist, IllegalStateException {

        while(true){
            int choice=showMenu();
            switch (choice) {
                case 1:
                    signup();
                    break;

                case 2:
                    try {
                        new LoginCli().start();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                    case 3:
                    System.exit(0);
                    break;
                default:
                    throw new InvalidChioceException("invalid choice");

            }

        }

    }
    public int showMenu(){
        CliPrinter.printMessage("1) Sign Up\n");
        CliPrinter.printMessage("2) Go to Login\n");
        CliPrinter.printMessage("3) Quit\n");
        return verifyChioce(1,3);
    }

    public void signup() throws IllegalStateException {

        RegisterController register = new RegisterController();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CliPrinter.printMessage("Name: ");
        try {
            String name = reader.readLine();
            CliPrinter.printMessage("Lastname: ");
            String last = reader.readLine();
            CliPrinter.printMessage("Date of birth(dd-mm-yyyy) ");
            String d= reader.readLine();
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date = sdf1.parse(d);
            java.sql.Date date1= new java.sql.Date(date.getTime());

            CliPrinter.printMessage("Username: ");
            String username = reader.readLine();
            CliPrinter.printMessage("Password: ");
            String pass  = reader.readLine();
            CliPrinter.printMessage("Confirm password: ");
            String conf = reader.readLine();
            if (!pass.equals(conf)){
                CliPrinter.printMessage("The password are differnt, insert them again.");
            }

            RegisterBean registerValue=new RegisterBean();
            registerValue.setUsernameBean( username);
            registerValue.setPasswdBean(pass);
            registerValue.setNameBean(name);
            registerValue.setCognomeBean(last);
            registerValue.setDateBean(date1.toLocalDate());


            register.insertUserDao(username, pass, name, Date.valueOf(date1.toLocalDate()), last);

        } catch (IOException | ParseException e) {
            e.getMessage();
        } catch (ExceptionUserAlreadyExist e) {
            CliPrinter.printMessage("user already exists");
        }

    }


}
