package it.uniroma2.ispw.cardemporium.factory;



public class ConcreteInterfaceMyCardMagic implements MyCardBaseInterface {
    boolean altered;
    boolean signed;
    boolean playset;
    boolean foil;
    @Override
    public String useCard() {
        return "magic";
    }
}
