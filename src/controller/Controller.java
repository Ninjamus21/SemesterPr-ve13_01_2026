package controller;

import model.*;
import storage.Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Controller {
    public static List<Juletræ> getJuletræ() {
        return Storage.getJuletræs();
    }

    public static Juletræ createJuletræ(Sort sort, int højde, int antalPrPalle) {
        Juletræ juletræ = new Juletræ(sort, højde, antalPrPalle);
        Storage.addJuletræ(juletræ);
        return juletræ;
    }

    // next
    public static List<JuletræsGrossist> getJuletræGrossist() {
        return Storage.getJuletræsGrossists();
    }

    public static JuletræsGrossist createJuletræsGrossist(String navn, String cvr, double fragtPrisPrPalle) {
        JuletræsGrossist juletræsGrossist = new JuletræsGrossist(navn, cvr, fragtPrisPrPalle);
        Storage.addJuletræsGrossist(juletræsGrossist);
        return juletræsGrossist;
    }

    // next
    public static List<Salg> getSalg() {
        return Storage.getSalg();
    }

    public static Salg createSalg(String kunde, LocalDate salgsDato) {
        Salg salg = new Salg(kunde, salgsDato);
        Storage.addsalg(salg);
        return salg;
    }

    public static void udskrivJuletræMagasin(String filnavn) {
        var juletræs = Storage.getJuletræs();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filnavn))) {
            for (Juletræ juletræ : juletræs) {
                var periodePrises = juletræ.getPeriodePrises();
                for (PeriodePris periodePris : periodePrises) {
                    bufferedWriter.write("Grossist " + juletræ.getJuletræsGrossist());
                    bufferedWriter.write(", Sort " + juletræ.getSort());
                    bufferedWriter.write(", Højde " + juletræ.getHøjde());
                    bufferedWriter.write(", fra Dato " + periodePris.getTilDato());
                    bufferedWriter.write(", til dato " + periodePris.getFraDato());
                    bufferedWriter.write(", pris. " + periodePris.getPris());
                    bufferedWriter.newLine();
                }

                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
