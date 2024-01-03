package it.uniroma2.ispw.cardemporium.bean;



public class CardInfoBean {
    private int id;
    private String nome;
    private Integer versione;
    private String gioco;
    private String set;
    private String condition;

    public CardInfoBean(int id, CardBean cardBean, String condition, Float price, Integer quantity, ExtraBeanDG extraBeanDG, String language) {
        this.id = id;
        this.nome=cardBean.getName();
        this.versione=cardBean.getVersionbean();
        this.gioco=cardBean.getGameBean();
        this.set=cardBean.getSetcardbean();
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.extraBeanDG = extraBeanDG;
        this.language = language;
    }

    public CardInfoBean(int id, CardBean cardBean, String condition, Float price, Integer quantity, ExtraBeanP extraBeanP, String language) {
        this.id = id;
        this.nome=cardBean.getName();
        this.versione=cardBean.getVersionbean();
        this.gioco=cardBean.getGameBean();
        this.set=cardBean.getSetcardbean();
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.extraBeanP = extraBeanP;
        this.language = language;
    }

    public CardInfoBean(int id, CardBean cardBean, String condition, Float price, Integer quantity, ExtraBeanY extraBeanY, String language) {
        this.id = id;
        this.nome=cardBean.getName();
        this.versione=cardBean.getVersionbean();
        this.gioco=cardBean.getGameBean();
        this.set=cardBean.getSetcardbean();
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.extraBeanY =extraBeanY;
        this.language = language;
    }

    private Float price;
    private Integer quantity;

    public CardInfoBean(int id, CardBean cardBean, String condition, Float price, Integer quantity, ExtraBeanM extraBeanM, String language) {
        this.id = id;
        this.nome=cardBean.getName();
        this.versione=cardBean.getVersionbean();
        this.gioco=cardBean.getGameBean();
        this.set=cardBean.getSetcardbean();
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.extraBeanM = extraBeanM;
        this.language = language;
    }

    ExtraBeanDG extraBeanDG;

    public ExtraBeanDG getExtraBeanDG() {
        return extraBeanDG;
    }



    public ExtraBeanY getExtraBeanY() {
        return extraBeanY;
    }



    public ExtraBeanP getExtraBeanP() {
        return extraBeanP;
    }



    public ExtraBeanM getExtraBeanM() {
        return extraBeanM;
    }



    ExtraBeanY extraBeanY;
    ExtraBeanP extraBeanP;
    ExtraBeanM extraBeanM;



    public CardInfoBean(int id, CardBean cardBean, String condition, Float price, Integer quantity, String language) {
        this.id = id;
        this.nome=cardBean.getName();
        this.versione=cardBean.getVersionbean();
        this.gioco=cardBean.getGameBean();
        this.set=cardBean.getSetcardbean();
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.language = language;

    }

    private String language;



    public CardInfoBean(String condition, Float price, Integer quantity, String language) {
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.language = language;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVersione() {
        return versione;
    }



    public String getGioco() {
        return gioco;
    }



    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
}
