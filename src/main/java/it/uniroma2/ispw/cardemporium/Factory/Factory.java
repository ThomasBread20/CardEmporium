package it.uniroma2.ispw.cardemporium.Factory;

import it.uniroma2.ispw.cardemporium.exception.CardGameException;

public class Factory {

    public CardBase createCard(int type)throws CardGameException {
        switch (type){
            case 1: return new concreteCardYugioh();
            case 2: return new concreteCardPokemon();
            case 3:return new concreteCardDragonball();
            case 4:return new concreteCardMagic();
            default: throw new CardGameException("invalid type");
        }

    }

public CardBase createConcreteCardY(){
        return new concreteCardYugioh();
    }
    public CardBase createConcreteCardP(){
        return new concreteCardPokemon();
    }
    public CardBase createConcreteCardM(){
        return new concreteCardMagic();
    }
    public CardBase createConcreteCardD(){
        return new concreteCardDragonball();
    }

}
