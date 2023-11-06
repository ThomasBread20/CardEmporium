package it.uniroma2.ispw.cardemporium.model;

public class Card {
  private   String name;
  private int id;
  private int version;
  private String setName;
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



    public String getnomeGioco() {
        return nomeGioco;
    }

    public void setNomeGioco(String nomeGioco) {
        this.nomeGioco = nomeGioco;
    }
    public Card(int idCard,String nameCard,int ver,String game,String set){
        this.id=idCard;
        this.name=nameCard;
        this.version=ver;
        this.nomeGioco=game;
        this.setName =set;


    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }
}
