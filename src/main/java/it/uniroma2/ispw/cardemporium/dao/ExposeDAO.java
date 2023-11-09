package it.uniroma2.ispw.cardemporium.dao;

import it.uniroma2.ispw.cardemporium.bean.ExtraBeanDG;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanM;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanP;
import it.uniroma2.ispw.cardemporium.bean.ExtraBeanY;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ExposeDAO {
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    private Connection connCheck() throws ExceptionDBerror {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    public Boolean exposeCardY(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, ExtraBeanY extraBeanY, Integer user)throws ExceptionDBerror {
        Connection conn = connCheck();
        Boolean sig=extraBeanY.isSigned();
        boolean al=extraBeanY.isAltered();
        Boolean fed=extraBeanY.isFedition();
        int i=0;
while (i++<quan) {
    String q = "CALL Expose_Y(?,?,?,?,?,?,?,?,?,?)";
    try {
        statement = conn.prepareStatement(q);
        statement.setString(1, name);
        statement.setInt(2, versione);
        statement.setFloat(3, price);
        statement.setString(4, cond);
        statement.setString(5, lan);
        statement.setInt(6, user);
        statement.setInt(7, id);
        statement.setBoolean(8, sig);
        statement.setBoolean(9, al);
        statement.setBoolean(10, fed);

        statement.executeQuery();
    } catch (SQLException e) {
        e.getErrorCode();
    }
}

        return true;
    }
    public Boolean exposeCardM(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, ExtraBeanM extraBeanM, Integer user)throws ExceptionDBerror {
        Connection conn = connCheck();
        Boolean sig=extraBeanM.isSigned();
        Boolean al=extraBeanM.isAltered();
        Boolean foil=extraBeanM.isFoil();
        Boolean ps=extraBeanM.isPlayset();
        int i=0;
while(i++<quan) {
    String q = "CALL Expose_M(?,?,?,?,?,?,?,?,?,?,?)";
    try {
        statement = conn.prepareStatement(q);
        statement.setString(1, name);
        statement.setInt(2, versione);
        statement.setFloat(3, price);
        statement.setString(4, cond);
        statement.setString(5, lan);
        statement.setInt(6, user);
        statement.setInt(7, id);
        statement.setBoolean(8, sig);
        statement.setBoolean(9, al);
        statement.setBoolean(10, foil);
        statement.setBoolean(11, ps);

         statement.executeQuery();
    } catch (SQLException e) {
        e.getErrorCode();
    }
}

        return true;
    }
    public Boolean exposeCardDB(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, ExtraBeanDG extraBeanDG, Integer user)throws ExceptionDBerror {
        Connection conn = connCheck();
        Boolean sig=extraBeanDG.isSigned();
        Boolean al=extraBeanDG.isAltered();
        Boolean foil=extraBeanDG.isFoil();
        int i=0;
        while (i++<quan) {

            String q = "CALL Expose_Y(?,?,?,?,?,?,?,?,?,?)";
            try {
                statement = conn.prepareStatement(q);
                statement.setString(1, name);
                statement.setInt(2, versione);
                statement.setFloat(3, price);
                statement.setString(4, cond);
                statement.setString(5, lan);
                statement.setInt(6, user);
                statement.setInt(7, id);
                statement.setBoolean(8, sig);
                statement.setBoolean(9, al);
                statement.setBoolean(10, foil);

                statement.executeQuery();
            } catch (SQLException e) {
                e.getErrorCode();
            }
        }
        return true;
    }
    public Boolean exposeCardP(Float price, Integer quan, String lan, String cond, Integer id, String name, Integer versione, ExtraBeanP extraBeanP, Integer user)throws ExceptionDBerror {
        Connection conn = connCheck();
        Boolean sig=extraBeanP.isSigned();
        Boolean al=extraBeanP.isAltered();
        Boolean fed=extraBeanP.isFedition();
        Boolean ps=extraBeanP.isPlayset();
        Boolean rev=extraBeanP.isReverse();
int i=0;
while (i++<quan) {


    String q = "CALL Expose_Y(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
        statement = conn.prepareStatement(q);
        statement.setString(1, name);
        statement.setInt(2, versione);
        statement.setFloat(3, price);
        statement.setString(4, cond);
        statement.setString(5, lan);
        statement.setInt(6, user);
        statement.setInt(7, id);
        statement.setBoolean(8, sig);
        statement.setBoolean(9, al);
        statement.setBoolean(10, fed);
        statement.setBoolean(11, rev);
        statement.setBoolean(12, ps);

         statement.executeQuery();
    } catch (SQLException e) {
        e.getErrorCode();
    }
}

        return true;
    }

}
