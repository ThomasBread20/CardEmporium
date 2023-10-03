package it.uniroma2.ispw.cardemporium.Factory;

public class concreteCardPokemon implements CardBase{
    boolean altered;
    boolean signed;
    boolean first_edition;
    boolean playset;
    boolean reverse_holo;

    @Override
    public String useCard() {
        return "poke";
    }
}
