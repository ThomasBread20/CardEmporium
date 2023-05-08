package it.uniroma2.ispw.cardemporium.model;

public class Card {
  private   String name;
  private int id;
  private int version;
  private int id_setCarte;
  private String nomeGioco;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getId_setCarte() {
        return id_setCarte;
    }

    public void setId_setCarte(int id_setCarte) {
        this.id_setCarte = id_setCarte;
    }

    public String getNomeGioco() {
        return nomeGioco;
    }

    public void setNomeGioco(String nomeGioco) {
        this.nomeGioco = nomeGioco;
    }
}
