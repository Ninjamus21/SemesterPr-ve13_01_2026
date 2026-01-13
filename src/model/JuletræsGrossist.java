package model;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class JuletræsGrossist {
    private String navn;
    private String cvr;
    private double fragtPrisPrPalle;
    private ArrayList<Juletræ> juletræs = new ArrayList<>();

    public JuletræsGrossist(String navn, String cvr, double fragtPrisPrPalle) {
        this.navn = navn;
        this.cvr = cvr;
        this.fragtPrisPrPalle = fragtPrisPrPalle;
    }

    public String getNavn() {
        return navn;
    }

    public String getCvr() {
        return cvr;
    }

    public double getFragtPrisPrPalle() {
        return fragtPrisPrPalle;
    }

    public ArrayList<Juletræ> getJuletræs() {
        return juletræs;
    }

    public void addJuletræ(Juletræ juletræ) {
        if (!juletræs.contains(juletræ)) {
            juletræs.add(juletræ);
            juletræ.setJuletræsGrossist(this);
        }
    }

    public void removeJuletræ(Juletræ juletræ){
        if (juletræs.contains(juletræ)){
            juletræs.remove(juletræ);
            juletræ.setJuletræsGrossist(null);
        }
    }

    public ArrayList<Juletræ> juleEfterHøjde(ArrayList<Juletræ> list) {
        ArrayList<Juletræ> swappedlist = new ArrayList<>();
        for (int i = 0; i < juletræs.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < juletræs.size(); j++) {
                if (list.get(j).getHøjde() < list.get(minPos).getHøjde()) {
                    minPos = j;
                }
            }
            // glemt syntax for dette:
//            swap(list, i, minPos);
//            swappedlist =
        }
    return swappedlist;
    }

    @Override
    public String toString() {
        return navn + ":";
    }
}
