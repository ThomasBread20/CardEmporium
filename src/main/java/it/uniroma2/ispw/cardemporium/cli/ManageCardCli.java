package it.uniroma2.ispw.cardemporium.cli;

import it.uniroma2.ispw.cardemporium.business.CliPrinter;

import it.uniroma2.ispw.cardemporium.controller.ManageControllerApp;
import it.uniroma2.ispw.cardemporium.model.CopiaCard;
import javafx.collections.ObservableList;

public class ManageCardCli {

   ObservableList<CopiaCard>copiaCards=null;
    public void start() {

        CliPrinter.printMessage("ID - Name - Version - Condition - price  - language  - set   - extra\n");

        copiaCards=ManageControllerApp.showCards();
        for(CopiaCard copiaCard :copiaCards){
            CliPrinter.printMessage(copiaCard.getCartaSingolaID()+" - "+copiaCard.getNomeCarta()+" - "+copiaCard.getVersione()+" - "+copiaCard.getCondizione()+" - "+copiaCard.getPrezzo()+" - "+copiaCard.getLingua()+" - "+copiaCard.getNomeSet()+" - "+copiaCard.getExtra());
        }
        CliPrinter.printMessage("\n");

    }
}