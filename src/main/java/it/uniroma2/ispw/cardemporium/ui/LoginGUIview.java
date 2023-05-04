package it.uniroma2.ispw.cardemporium.ui;


import it.uniroma2.ispw.cardemporium.bean.LoginBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static javafx.application.Application.launch;

public class LoginGUIview {
    public void LoginCLI() throws IOException {
        LoginBean cr=new LoginBean();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Username: ");
        String username = reader.readLine();
        cr.setUsernameBean(username);
        System.out.print("password: ");
        String pwd = reader.readLine();
        cr.setPasswdBean(pwd);
    }

}
