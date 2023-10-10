package it.uniroma2.ispw.cardemporium.Factory;

import it.uniroma2.ispw.cardemporium.ui.magicView;

public class concreteCardMagic implements CardBase{
    boolean altered;
    boolean signed;
    boolean playset;
    boolean foil;
    @Override
    public String useCard() {
        return "magic";
    }
}
