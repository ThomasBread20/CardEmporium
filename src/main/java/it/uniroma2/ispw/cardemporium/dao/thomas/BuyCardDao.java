package it.uniroma2.ispw.cardemporium.dao.thomas;

import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

public interface BuyCardDao {

    void buyCard(int id, int user) throws ExceptionDBerror;
}
