package storage;

import model.Juletræ;
import model.JuletræsGrossist;
import model.Salg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Storage {
    private static final ArrayList<JuletræsGrossist> juletræsGrossists = new ArrayList<>();
    private static final ArrayList<Juletræ> juletræs = new ArrayList<>();
    private static final ArrayList<Salg> salgs = new ArrayList<>();

    public static void addJuletræsGrossist(JuletræsGrossist juletræsGrossist){
        if (!juletræsGrossists.contains(juletræsGrossist)){
            juletræsGrossists.add(juletræsGrossist);
        }
    }
    public static void removeJuletræsGrossist(JuletræsGrossist juletræsGrossist){
        if (juletræsGrossists.contains(juletræsGrossist)){
            juletræsGrossists.remove(juletræsGrossist);
        }
    }
    public static List<JuletræsGrossist> getJuletræsGrossists(){
        return Collections.unmodifiableList(juletræsGrossists);
    }

    // next
    public static void addJuletræ(Juletræ juletræ){
        if (!juletræs.contains(juletræ)){
            juletræs.add(juletræ);
        }
    }

    public static void removeJuletræ(Juletræ juletræ){
        if (juletræs.contains(juletræ)){
            juletræs.remove(juletræ);
        }
    }

    public static List<Juletræ> getJuletræs(){
        return Collections.unmodifiableList(juletræs);
    }

    // next

    public static void addsalg(Salg salg){
        if (!salgs.contains(salg)){
            salgs.add(salg);
        }
    }

    public static void removesalg(Salg salg){
        if (salgs.contains(salg)){
            salgs.remove(salg);
        }
    }

    public static List<Salg> getSalg(){
        return Collections.unmodifiableList(salgs);
    }


}
