package it.uniroma2.ispw.cardemporium.Pattern;

import it.uniroma2.ispw.cardemporium.Pattern.Observer;

import java.util.ArrayList;

public abstract class Subject {
    /** soggetto dell'osservazione per vederne i cambiamenti: VendorOrderBean */
    private ArrayList<Observer> observerArrayList;
    protected Subject () {
        observerArrayList = new ArrayList<>();
    }
    public void attach (Observer newObs) {
        observerArrayList.add(newObs);
    }
    public void detach(Observer removeObs){
        observerArrayList.remove(removeObs);
    }
    protected void notifyObservers(){
        for(Observer obs : observerArrayList){
            obs.update();
        }
    }

}
