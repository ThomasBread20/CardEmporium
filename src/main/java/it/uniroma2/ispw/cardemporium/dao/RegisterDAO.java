package it.uniroma2.ispw.cardemporium.dao;


import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;

public interface RegisterDAO {
    void addUser(String username,String pwd,String name,java.sql.Date date,String cognome) throws ExceptionUserAlreadyExist;
}
