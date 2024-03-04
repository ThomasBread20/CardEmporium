package it.uniroma2.ispw.cardemporium.bean.thomas;






public class CardBean {
    private String namebean;
    private String setcardbean;


    public CardBean(String namebean, int versionbean, String gamebean, String setcardbean) {
        this.namebean = namebean;
        this.setcardbean = setcardbean;
        this.versionbean = versionbean;
        this.gamebean = gamebean;
    }

    private int versionbean;
    private String gamebean;

    public String getName() {
        return namebean;
    }

    public void setName(String name) {
        this.namebean = name;

    }

    public String getSetcardbean() {
        return setcardbean;
    }



    public int getVersionbean() {
        return versionbean;
    }



    public String getGameBean() {
        return gamebean;
    }




}
