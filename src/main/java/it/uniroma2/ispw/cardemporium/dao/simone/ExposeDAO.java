package it.uniroma2.ispw.cardemporium.dao.simone;

import it.uniroma2.ispw.cardemporium.bean.simone.CardInfoBean;
import it.uniroma2.ispw.cardemporium.dao.Connection1Singelton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ExposeDAO {
    PreparedStatement statement = null;

    private Connection connCheck()  {
        Connection1Singelton conn = Connection1Singelton.getInstance();
        return conn.getConn();

    }

    public Boolean exposeCardY(CardInfoBean cardInfoBean, Integer user) {
        Connection conn = connCheck();
        Boolean sig= cardInfoBean.getExtraBeanY().isSigned();
        boolean al=cardInfoBean.getExtraBeanY().isAltered();
        Boolean fed=cardInfoBean.getExtraBeanY().isFedition();


    String q = "CALL Expose_Y(?,?,?,?,?,?,?,?,?,?)";
    try {
        statement = conn.prepareStatement(q);
        statement.setString(1, cardInfoBean.getNome());
        statement.setInt(2, cardInfoBean.getVersione());
        statement.setFloat(3, cardInfoBean.getPrice());
        statement.setString(4, cardInfoBean.getCondition());
        statement.setString(5, cardInfoBean.getLanguage());
        statement.setInt(6, user);
        statement.setInt(7, cardInfoBean.getId());
        statement.setBoolean(8, sig);
        statement.setBoolean(9, al);
        statement.setBoolean(10, fed);

        statement.executeQuery();
    } catch (SQLException e) {
        e.getErrorCode();
    }


        return true;
    }
    public Boolean exposeCardM(CardInfoBean cardInfoBean, Integer user) {
        Connection conn = connCheck();
        Boolean sig=cardInfoBean.getExtraBeanM().isSigned();
        Boolean al=cardInfoBean.getExtraBeanM().isAltered();
        Boolean foil=cardInfoBean.getExtraBeanM().isFoil();
        Boolean ps=cardInfoBean.getExtraBeanM().isPlayset();


    String q = "CALL Expose_M(?,?,?,?,?,?,?,?,?,?,?)";
    try {
        statement = conn.prepareStatement(q);
        statement.setString(1, cardInfoBean.getNome());
        statement.setInt(2, cardInfoBean.getVersione());
        statement.setFloat(3, cardInfoBean.getPrice());
        statement.setString(4, cardInfoBean.getCondition());
        statement.setString(5, cardInfoBean.getLanguage());
        statement.setInt(6, user);
        statement.setInt(7, cardInfoBean.getId());
        statement.setBoolean(8, sig);
        statement.setBoolean(9, al);
        statement.setBoolean(10, foil);
        statement.setBoolean(11, ps);

         statement.executeQuery();
    } catch (SQLException e) {
        e.getErrorCode();
    }


        return true;
    }
    public Boolean exposeCardDB(CardInfoBean cardInfoBean, Integer user) {
        Connection conn = connCheck();
        Boolean sig=cardInfoBean.getExtraBeanDG().isSigned();
        Boolean al=cardInfoBean.getExtraBeanDG().isAltered();
        Boolean foil=cardInfoBean.getExtraBeanDG().isFoil();



            String q = "CALL Expose_Y(?,?,?,?,?,?,?,?,?,?)";
            try {
                statement = conn.prepareStatement(q);
                statement.setString(1, cardInfoBean.getNome());
                statement.setInt(2, cardInfoBean.getVersione());
                statement.setFloat(3, cardInfoBean.getPrice());
                statement.setString(4, cardInfoBean.getCondition());
                statement.setString(5, cardInfoBean.getLanguage());
                statement.setInt(6, user);
                statement.setInt(7, cardInfoBean.getId());
                statement.setBoolean(8, sig);
                statement.setBoolean(9, al);
                statement.setBoolean(10, foil);

                statement.executeQuery();
            } catch (SQLException e) {
                e.getErrorCode();
            }

        return true;
    }
    public Boolean exposeCardP(CardInfoBean cardInfoBean, Integer user) {
        Connection conn = connCheck();
        Boolean sig=cardInfoBean.getExtraBeanP().isSigned();
        Boolean al=cardInfoBean.getExtraBeanP().isAltered();
        Boolean fed=cardInfoBean.getExtraBeanP().isFedition();
        Boolean ps=cardInfoBean.getExtraBeanP().isPlayset();
        Boolean rev=cardInfoBean.getExtraBeanP().isReverse();


    String q = "CALL Expose_Y(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
        statement = conn.prepareStatement(q);
        statement.setString(1, cardInfoBean.getNome());
        statement.setInt(2, cardInfoBean.getVersione());
        statement.setFloat(3, cardInfoBean.getPrice());
        statement.setString(4, cardInfoBean.getCondition());
        statement.setString(5, cardInfoBean.getLanguage());
        statement.setInt(6, user);
        statement.setInt(7, cardInfoBean.getId());
        statement.setBoolean(8, sig);
        statement.setBoolean(9, al);
        statement.setBoolean(10, fed);
        statement.setBoolean(11, rev);
        statement.setBoolean(12, ps);

         statement.executeQuery();
    } catch (SQLException e) {
        e.getErrorCode();
    }
        return true;
    }

}
