package it.uniroma2.ispw.cardemporium.factory;



public class ConcreteInterfaceMyCardPokemon implements MyCardBaseInterface {
    boolean altered;
    boolean signed;
    boolean firstedition;
    boolean playset;
    boolean reverseholo;

    @Override
    public String  useCard() {
        return "poke";
    }
}
