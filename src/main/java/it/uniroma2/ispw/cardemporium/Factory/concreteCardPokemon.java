package it.uniroma2.ispw.cardemporium.Factory;



public class concreteCardPokemon implements CardBase{
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
