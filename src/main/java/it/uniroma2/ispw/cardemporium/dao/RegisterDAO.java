package it.uniroma2.ispw.cardemporium.dao;



public interface RegisterDAO {
    public void addUser(String username,String pwd,String name,java.sql.Date date,String cognome) throws Exception;
}
