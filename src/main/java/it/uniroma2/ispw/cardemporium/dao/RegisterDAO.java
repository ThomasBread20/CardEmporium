package it.uniroma2.ispw.cardemporium.dao;


import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.business.DBFunc;
import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {

    boolean result;

    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()
    {
        Connection conn = DBconnection.getDBInstance().getConnection();
        return conn;
    }

    public Boolean addUser(RegisterBean credential) throws SQLException, ExceptionUserAlreadyExist {

        Connection conn = connCheck();

        String username = credential.getUsernameBean();
        DBFunc.Register();

        String Password = credential.getPasswdBean();
        String Name = credential.getNameBean();
        java.sql.Date Date = credential.getDateBean();
        String Surname = credential.getCognomeBean();


        String sql = "CALL `Inserisci-Utente`(?, ?, ?, ?, ?)";



        try {

            statement = conn.prepareCall(sql);
            statement.setString(1, username);
            statement.setString(2, Password);
            statement.setString(3, Name);
            statement.setString(4, Surname);
            statement.setDate(5, Date);
            statement.executeQuery();

            return true;

        }catch (SQLException e) {

            throw new ExceptionUserAlreadyExist("");
        }


    }

}

