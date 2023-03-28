package it.uniroma2.ispw.cardemporium.bean;

import it.uniroma2.ispw.cardemporium.controller.LoginController;
import it.uniroma2.ispw.cardemporium.exception.ExceptionBannedUser;
import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionSwitchpage;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserNotExist;
import it.uniroma2.ispw.cardemporium.ui.SwitchPage;
import it.uniroma2.ispw.cardemporium.users.Users;
import javafx.event.ActionEvent;


import java.io.IOException;

public class LoginBean {
    private String usernameBean;
    private String passwdBean;


    public String getPasswdBean() {
        return passwdBean;
    }

    public void setPasswdBean(String passwdBean) {
        this.passwdBean = passwdBean;
    }

    public String getUsernameBean() {
        return usernameBean;
    }

    public void setUsernameBean(String usernameBean) {
        this.usernameBean = usernameBean;
    }

    public void result( ActionEvent event) throws ExceptionDBerror, ExceptionUserNotExist, ExceptionBannedUser, IOException, ExceptionSwitchpage {

        try{
            Users user = LoginController.checkUserDao(getUsernameBean(), getPasswdBean());
            LoginController.dataFuller(user.getPwd(), user.getUsername(), user.getName(), user.getSurname(), user.getData(), user.getIsBanned(), user.getRole());


            SwitchPage page = SwitchPage.getInstance();
            page.switchPage(user.getHomePage(), event);

        } catch (ExceptionDBerror e) {
            throw new ExceptionDBerror("");
        } catch (ExceptionSwitchpage e) {
            throw new ExceptionSwitchpage("");
        }




    }

}
