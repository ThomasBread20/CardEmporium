package it.uniroma2.ispw.cardemporium.factory;

import it.uniroma2.ispw.cardemporium.exception.CardGameException;

public class Factory {

    public MyCardBaseInterface createCard(int type)throws CardGameException {
        switch (type){
            case 1: return new ConcreteInterfaceMyCardYugioh();
            case 2: return new ConcreteInterfaceMyCardPokemon();
            case 3:return new ConcreteInterfaceMyCardDragonball();
            case 4:return new ConcreteInterfaceMyCardMagic();
            default: throw new CardGameException("invalid type");
        }

    }

public MyCardBaseInterface createConcreteCardY(){
        return new ConcreteInterfaceMyCardYugioh();
    }
    public MyCardBaseInterface createConcreteCardP(){
        return new ConcreteInterfaceMyCardPokemon();
    }
    public MyCardBaseInterface createConcreteCardM(){
        return new ConcreteInterfaceMyCardMagic();
    }
    public MyCardBaseInterface createConcreteCardD(){
        return new ConcreteInterfaceMyCardDragonball();
    }

}
