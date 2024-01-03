package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.business.DBFunc;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;


import java.sql.*;

public class RegisterDAODB implements RegisterDAO{



    PreparedStatement statement = null;


    private Connection connCheck()  {

        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();
    }

    public void addUser(String username1, String passw, String name1, Date date1, String surname1) throws ExceptionUserAlreadyExist {

        Connection conn = null;
        try {
            conn = connCheck();
            assert conn!=null;
        } catch (NullPointerException e) {
            e.getCause();
        }

        try {
            DBFunc.register();
        } catch (SQLException |NullPointerException e) {
            e.getCause();
        }


        String sql = "CALL `Inserisci-Utente`(?, ?, ?, ?, ?)";


        if(conn != null){
        try {

                statement = conn.prepareCall(sql);

        } catch (SQLException |NullPointerException ex) {
            ex.toString();
        }
        try {
            statement.setString(1, username1);
            statement.setString(2, passw);
            statement.setString(3, name1);
            statement.setString(4, surname1);
            statement.setDate(5, date1);
            statement.executeQuery();
        } catch (SQLException ex) {
            throw new ExceptionUserAlreadyExist("");

        }

    }





    }

}

