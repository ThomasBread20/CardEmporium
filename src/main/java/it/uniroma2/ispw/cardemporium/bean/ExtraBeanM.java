package it.uniroma2.ispw.cardemporium.bean;

public class ExtraBeanM {
    private boolean signed;
    private boolean altered;

    public boolean isSigned() {
        return signed;
    }

    public ExtraBeanM(boolean signed, boolean altered, boolean foil, boolean playset, int id, int v, String n) {
        this.signed = signed;
        this.altered = altered;
        this.foil = foil;
        this.playset = playset;
        this.id = id;
        this.v = v;
        this.n = n;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isAltered() {
        return altered;
    }

    public void setAltered(boolean altered) {
        this.altered = altered;
    }

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public boolean isPlayset() {
        return playset;
    }

    public void setPlayset(boolean playset) {
        this.playset = playset;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    private boolean foil;
    private boolean playset;
    private int id;
    private int v;
    private String n;

}
