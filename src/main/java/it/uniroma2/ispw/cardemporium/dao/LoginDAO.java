package it.uniroma2.ispw.cardemporium.dao;




import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.users.Users;
import it.uniroma2.ispw.cardemporium.users.UtenteFactory;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {



    PreparedStatement statement = null;
    ResultSet resultSet = null;


    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }



    public Users getUser(String username1, String passw1) throws ExceptionBannedUser, ExceptionUserNotExist, ExceptionDBerror {

        String sql = "SELECT utenti_ID FROM credenziali WHERE Username = ? and PasswordUtente = ? ";
        Connection conn = connCheck();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, username1);
            statement.setString(2, passw1);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new ExceptionUserNotExist("User does not exists");
            }

            int id;
            id = resultSet.getInt("utenti_ID");


            String sql2 = "SELECT Nome, Cognome,DataNascita,Ruolo, ID,IsBanned  FROM utenti JOIN credenziali WHERE ID = ?;";


            statement = conn.prepareStatement(sql2);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            if (resultSet.getBoolean("IsBanned")) {
                throw new ExceptionBannedUser("The User is Banned");
            } else {
                return  UtenteFactory.getUser(passw1,
                        username1,
                        resultSet.getString("Nome"),
                        resultSet.getString("Cognome"),
                        resultSet.getDate("DataNascita"),
                        resultSet.getString("Ruolo"),
                        resultSet.getInt("ID")
                        );

            }
        } catch (SQLException e) {
            throw new ExceptionDBerror("SQL Error");
        }

    }
}


