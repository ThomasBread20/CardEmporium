package it.uniroma2.ispw.cardemporium.cli;


import it.uniroma2.ispw.cardemporium.bean.simone.CardBean;
import it.uniroma2.ispw.cardemporium.utility.CliPrinter;
import it.uniroma2.ispw.cardemporium.controller.simone.ExposeController;
import it.uniroma2.ispw.cardemporium.exception.*;
import it.uniroma2.ispw.cardemporium.model.simone.Card;
import javafx.collections.ObservableList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class ExposeCardCli extends CliManager{


    public void start() throws CardGameException {
        ObservableList<Card>card;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            CliPrinter.printMessage("Type the card's name: ");
            String name= reader.readLine();

            CliPrinter.printMessage("Version: ");
            int ver= Integer.parseInt(reader.readLine());
            if(ver<1 || ver >3){
                CliPrinter.printMessage("Incorrect value");
                new HomePage().start();
            }


            CliPrinter.printMessage("Write the game's name among these possible choices [Yu-gi-oh, Pokemon, DragonBall, Magic]: ");
            String game=reader.readLine();

            CliPrinter.printMessage("Write the set's name: ");
            String set= reader.readLine();
            CardBean cardBean=new CardBean(name,ver,game,set);
            ExposeController exposeController=new ExposeController();

           card=exposeController.searchAllCard(cardBean);

            if(game.equals("Yu-gi-oh")){
                new ExposeY().expose(card);
            } else if (game.equals("Pokemon")) {
                new ExposeP().expose(card);
            } else if (game.equals("DragonBall")) {
                new ExposeDG().expose(card);
            } else if (game.equals("Magic")) {
                new ExposeM().expose(card);
            }
            else throw new CardGameException("Invalid name");
        } catch (IOException | InvalidChioceException | ExceptionCardNotExist | SQLException | ExceptionDBerror e) {
            e.getMessage();
        }

    }





}
