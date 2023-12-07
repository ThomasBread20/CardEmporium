import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.controller.LoginController;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class bannedtest {


    LoginBean loginBean=new LoginBean();
    @Test
    void loginTest() throws ExceptionUserNotExist, ExceptionDBerror, ExceptionBannedUser {
        loginBean.setUsernameBean("Letizia");
        loginBean.setPasswdBean("leti");


        try {
            LoginController.checkUserDao(loginBean.getUsernameBean(),loginBean.getPasswdBean());
            Assertions.fail();
        }catch (ExceptionBannedUser e){
            e.getMessage();
        }
    }
}