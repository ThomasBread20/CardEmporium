package it.uniroma2.ispw.cardemporium.factory;



public class ConcreteInterfaceMyCardMagic implements MyCardBaseInterface {

    @Override
    public String useCard() {
        return "magic";
    }
}
