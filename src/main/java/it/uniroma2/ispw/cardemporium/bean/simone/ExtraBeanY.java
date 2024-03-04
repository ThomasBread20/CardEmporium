package it.uniroma2.ispw.cardemporium.bean.simone;

public class ExtraBeanY {
    public boolean isAltered() {
        return altered;
    }

    public int getId() {
        return id;
    }

    public ExtraBeanY(int id, int v, String n, boolean altered, boolean signed, boolean fedition) {
        this.id = id;
        this.v = v;
        this.n = n;
        this.altered = altered;
        this.signed = signed;
        this.fedition = fedition;
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

    private int id;
    private int v;
    private String n;

    public void setAltered(boolean altered) {
        this.altered = altered;
    }

    public ExtraBeanY(boolean altered, boolean signed, boolean fedition) {
        this.altered = altered;
        this.signed = signed;
        this.fedition = fedition;
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



    private boolean altered;
    private boolean signed;
    private boolean fedition;
}
