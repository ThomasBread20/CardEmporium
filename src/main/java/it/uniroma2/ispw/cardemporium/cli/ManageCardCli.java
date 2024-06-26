package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.utility.CliPrinter;

import it.uniroma2.ispw.cardemporium.controller.ManageControllerApp;
import it.uniroma2.ispw.cardemporium.model.simone.CardEntitySImo;
import javafx.collections.ObservableList;

public class ManageCardCli {

   ObservableList<CardEntitySImo>copiaCards=null;
    public void start() {

        ManageControllerApp app =  new ManageControllerApp();

        CliPrinter.printMessage("ID - Name - Version - Condition - price  - language  - set   - extra\n");

        copiaCards=app.showCards();
        for(CardEntitySImo copiaCard :copiaCards){
            CliPrinter.printMessage(copiaCard.getCartaSingolaID()+" - "+copiaCard.getNomeCarta()+" - "+copiaCard.getVersione()+" - "+copiaCard.getCondizione()+" - "+copiaCard.getPrezzo()+" - "+copiaCard.getLingua()+" - "+copiaCard.getNomeSet()+" - "+copiaCard.getExtra());
        }
        CliPrinter.printMessage("\n");

    }
}
