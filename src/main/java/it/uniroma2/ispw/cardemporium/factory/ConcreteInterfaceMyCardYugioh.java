package it.uniroma2.ispw.cardemporium.factory;



public class ConcreteInterfaceMyCardYugioh implements MyCardBaseInterface {
    boolean altered;
    boolean signed;
    boolean firstedition;

    @Override
    public String useCard() {

        return "Yu-gi-oh";
    }
}
