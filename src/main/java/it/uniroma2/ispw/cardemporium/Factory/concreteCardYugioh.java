package it.uniroma2.ispw.cardemporium.Factory;



public class concreteCardYugioh implements CardBase{
    boolean altered;
    boolean signed;
    boolean firstedition;

    @Override
    public String useCard() {

        return "yugioh";
    }
}
