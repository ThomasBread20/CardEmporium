package it.uniroma2.ispw.cardemporium.bean;

public class ExtraBeanG {

    private boolean altered;

    private boolean singed;

    private boolean foil;

    private boolean firstEd;

    private boolean reverseHolo;

    private boolean playset;

    public boolean isAltered() {
        return altered;
    }

    public boolean isSinged() {
        return singed;
    }

    public boolean isFoil() {
        return foil;
    }

    public boolean isFirstEd() {
        return firstEd;
    }

    public boolean isReverseHolo() {
        return reverseHolo;
    }

    public boolean isPlayset() {
        return playset;
    }

    public void setAll(boolean altered, boolean singed, boolean foil, boolean firstEd, boolean reverseHolo, boolean playset) {
        this.altered = altered;
        this.singed = singed;
        this.foil = foil;
        this.firstEd = firstEd;
        this.reverseHolo = reverseHolo;
        this.playset = playset;
    }
}
