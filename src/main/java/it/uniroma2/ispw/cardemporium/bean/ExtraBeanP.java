package it.uniroma2.ispw.cardemporium.bean;

public class ExtraBeanP {
    private boolean altered;
    private int cardid;





    public String getNome() {
        return nome;
    }

    public ExtraBeanP( int cardid, String nome, int v, ExtraBeanG extraBeanG) {

        this.cardid = cardid;
        this.nome = nome;
        this.v = v;
        this.altered=extraBeanG.isAltered();
        this.fedition=extraBeanG.isFirstEd();
        this.playset=extraBeanG.isPlayset();
        this.reverse=extraBeanG.isReverseHolo();
        this.signed=extraBeanG.isSinged();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }





    private String nome;
    private int v;

    public boolean isAltered() {
        return altered;
    }

    public ExtraBeanP(boolean altered, boolean signed, boolean fedition, boolean playset, boolean reverse) {
        this.altered = altered;
        this.signed = signed;
        this.fedition = fedition;
        this.playset = playset;
        this.reverse = reverse;
    }

    public void setAltered(boolean altered) {
        this.altered = altered;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isFedition() {
        return fedition;
    }



    public boolean isPlayset() {
        return playset;
    }

    public void setPlayset(boolean playset) {
        this.playset = playset;
    }

    public boolean isReverse() {
        return reverse;
    }


    private boolean signed;
    private boolean fedition;
    private boolean playset;
    private boolean reverse;
}
