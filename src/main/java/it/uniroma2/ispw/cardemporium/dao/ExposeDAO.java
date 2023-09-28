package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.business.DBconnection;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static it.uniroma2.ispw.cardemporium.business.DBconstants.SQL4;
import static it.uniroma2.ispw.cardemporium.business.DBconstants.SQL5;

public class ExposeDAO {
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    private Connection connCheck() {
        return DBconnection.getDBInstance().getConnection();

    }

    public Boolean ExposeCard(Float price,Integer quan,String lan, String cond,Integer id,String name,Integer versione,String user)throws ExceptionDBerror {
        Connection conn = connCheck();

        String q="CALL Expose(?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(q);
            statement.setString(1,cond);
            statement.setFloat(2,price);
            statement.setString(3,user);
            statement.setInt(4,id);
            statement.setString(5,name);
            statement.setInt(6,versione);
            statement.setString(7,lan);
            ResultSet rs=statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
