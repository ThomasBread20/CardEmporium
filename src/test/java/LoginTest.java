import it.uniroma2.ispw.cardemporium.bean.LoginBean;
import it.uniroma2.ispw.cardemporium.controller.LoginController;

import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import it.uniroma2.ispw.cardemporium.users.Users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class LoginTest {

//GUIDATO SIMONE
    LoginBean loginBean=new LoginBean();
    @Test
    void loginTest() throws ExceptionUserNotExist, ExceptionDBerror, ExceptionBannedUser{
        loginBean.setUsernameBean("Thomas");
        loginBean.setPasswdBean("Thomas2");
        LoginController login = new LoginController();

        Users user= login.checkUser(loginBean.getUsernameBean(),loginBean.getPasswdBean());
        try {
            Assertions.assertEquals("Thomas", user.getUsername());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
}
