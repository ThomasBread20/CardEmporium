package it.uniroma2.ispw.cardemporium.dao;



import it.uniroma2.ispw.cardemporium.business.DBFunc;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAODB implements RegisterDAO{

    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck() throws ExceptionDBerror {

        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();
    }

    public void addUser(String username1, String passw, String name1, java.sql.Date date1, String surname1) throws ExceptionUserAlreadyExist, ExceptionDBerror, SQLException {

        Connection conn = connCheck();

        String username = username1;
        DBFunc.register();

        String passwdBean = passw;
        String name = name1;
        java.sql.Date date = date1;
        String surname = surname1;


        String sql = "CALL `Inserisci-Utente`(?, ?, ?, ?, ?)";



        try {

            statement = conn.prepareCall(sql);
            statement.setString(1, username);
            statement.setString(2, passwdBean);
            statement.setString(3, name);
            statement.setString(4, surname);
            statement.setDate(5, date);
            statement.executeQuery();



        }catch (SQLException e) {

            throw new ExceptionUserAlreadyExist("");
        }


    }

}
