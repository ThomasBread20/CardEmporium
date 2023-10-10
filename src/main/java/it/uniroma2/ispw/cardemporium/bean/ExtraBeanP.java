package it.uniroma2.ispw.cardemporium.bean;

public class ExtraBeanP {
    private boolean altered;
    private int card_id;

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getNome() {
        return nome;
    }

    public ExtraBeanP(boolean altered, int card_id, String nome, int v, boolean signed, boolean fedition, boolean playset, boolean reverse) {
        this.altered = altered;
        this.card_id = card_id;
        this.nome = nome;
        this.v = v;
        this.signed = signed;
        this.fedition = fedition;
        this.playset = playset;
        this.reverse = reverse;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
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

    public void setFedition(boolean fedition) {
        this.fedition = fedition;
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

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    private boolean signed;
    private boolean fedition;
    private boolean playset;
    private boolean reverse;
}
