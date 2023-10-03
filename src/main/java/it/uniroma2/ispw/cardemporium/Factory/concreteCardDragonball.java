package it.uniroma2.ispw.cardemporium.Factory;

public class concreteCardDragonball implements CardBase{
    boolean altered;
    boolean foil;
    boolean signed;
    @Override
    public String useCard() {
        return "dg";
    }
}
