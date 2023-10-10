package it.uniroma2.ispw.cardemporium.Factory;

import it.uniroma2.ispw.cardemporium.ui.YugiohView;

public class concreteCardYugioh implements CardBase{
    boolean altered;
    boolean signed;
    boolean first_edition;

    @Override
    public String useCard() {
        //new YugiohView();
        return "yugioh";
    }
}
