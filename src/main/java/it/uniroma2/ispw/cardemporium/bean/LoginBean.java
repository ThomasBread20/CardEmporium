package it.uniroma2.ispw.cardemporium.bean;

public class LoginBean {
    private String UsernameBean;
    private String PasswdBean;


    public Boolean result;




    public String getPasswdBean() {
        return PasswdBean;
    }

    public void setPasswdBean(String passwdBean) {
        PasswdBean = passwdBean;
    }

    public String getUsernameBean() {
        return UsernameBean;
    }

    public void setUsernameBean(String usernameBean) {
        UsernameBean = usernameBean;
    }
    public boolean checkUsernameSyntax(String UsernameBean){

        return result;
    }


}
