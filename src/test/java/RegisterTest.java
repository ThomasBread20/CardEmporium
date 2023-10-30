import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.dao.RegisterDAO;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

public class RegisterTest {
    RegisterBean registerBean=new RegisterBean();
    @Test
    public void regTest() throws SQLException, ExceptionDBerror, ExceptionUserAlreadyExist {
        registerBean.setNameBean("test");
        registerBean.setCognomeBean("test");
        registerBean.setDateBean(LocalDate.parse("2000-11-06"));
        registerBean.setPasswdBean("test");
        registerBean.setUsernameBean("test");
        RegisterDAO registerDAO=new RegisterDAO();
    try {
        registerDAO.addUser(registerBean.getUsernameBean(),registerBean.getPasswdBean(),registerBean.getNameBean(),registerBean.getDateBean(), registerBean.getCognomeBean());
        Assertions.fail();
    }catch(ExceptionUserAlreadyExist e){
        e.getMessage();
    }

    }
}
