package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;
import it.uniroma2.ispw.cardemporium.exception.InvalidChioceException;
import it.uniroma2.ispw.cardemporium.model.Card;
import javafx.collections.ObservableList;

import static it.uniroma2.ispw.cardemporium.cli.CliManager.verifyChioce;

public interface Expose {
    void expose(ObservableList<Card>card);
    static String choiceLang(int g) throws InvalidChioceException {
        switch(g){
            case 1: return "Italian";

            case 2: return "French";

            case 3: return "German";

            case 4: return "English";

            default: throw new InvalidChioceException("invalid choice");
        }
    }
    static String choiceCond(int c) throws InvalidChioceException {
        switch (c){
            case 1: return "Near Mint";
            case 2: return "Excellent";

            case 3: return "Good";

            case 4: return "Light Played";

            case 5:return "poor";

            default: throw new InvalidChioceException("invalid choice");
        }
    }
    static int menu(){
        CliPrinter.printMessage("Condition:");
        CliPrinter.printMessage("1)Near mint");
        CliPrinter.printMessage("2)Excellent");
        CliPrinter.printMessage("3)Good");
        CliPrinter.printMessage("4)Light played");
        CliPrinter.printMessage("5)Poor");
        return verifyChioce(1,5);
    }
    static int menuLan(){
        CliPrinter.printMessage("Language:");
        CliPrinter.printMessage("1)Italian");
        CliPrinter.printMessage("2)French");
        CliPrinter.printMessage("3)German");
        CliPrinter.printMessage("4)English");
        return verifyChioce(1,4);
    }

}
