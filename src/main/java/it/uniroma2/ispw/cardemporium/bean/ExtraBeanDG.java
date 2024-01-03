package it.uniroma2.ispw.cardemporium.bean;

public class ExtraBeanDG {
    private boolean signed;
    private boolean altered;

    public boolean isSigned() {
        return signed;
    }

    public ExtraBeanDG(boolean signed, boolean altered, boolean foil, int id, int v, String n) {
        this.signed = signed;
        this.altered = altered;
        this.foil = foil;
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
    private int id;
    private int v;
    private String n;

}
