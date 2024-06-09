import it.uniroma2.ispw.cardemporium.bean.RegisterBean;
import it.uniroma2.ispw.cardemporium.dao.RegisterDAODB;

import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

 class RegisterTest {
    //GUIDATO SIMONE
    RegisterBean registerBean=new RegisterBean();
    @Test
     void regTest(){
        registerBean.setNameBean("test");
        registerBean.setCognomeBean("test");
        registerBean.setDateBean(LocalDate.parse("2000-11-06"));
        registerBean.setPasswdBean("test");
        registerBean.setUsernameBean("test");
        RegisterDAODB registerDAO=new RegisterDAODB();
    try {
        registerDAO.addUser(registerBean.getUsernameBean(),registerBean.getPasswdBean(),registerBean.getNameBean(),registerBean.getDateBean(), registerBean.getCognomeBean());
        Assertions.fail();
    }catch(ExceptionUserAlreadyExist e){
        e.getMessage();
    }

    }
}
