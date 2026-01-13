package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salg {
    private String kunde;
    private LocalDate salgsDato;
    private ArrayList<Salgslinje> salgslinjes = new ArrayList<>();

    public Salg(String kunde, LocalDate salgsDato) {
        this.kunde = kunde;
        this.salgsDato = salgsDato;
    }

    public Salgslinje createSalgslinje(int antal, double aftaltRabatPrTræ, Juletræ juletræ, Salg salg) {
        Salgslinje salgslinje = new Salgslinje(antal, aftaltRabatPrTræ, juletræ, salg);
        salgslinjes.add(salgslinje);
        return salgslinje;
    }

    public void removeSalgslinje(Salgslinje salgslinje) {
        if (salgslinjes.contains(salgslinje)) {
            salgslinjes.remove(salgslinje);
        }
    }

    public String getKunde() {
        return kunde;
    }

    public LocalDate getSalgsDato() {
        return salgsDato;
    }

    public double prisInclusiveFragt() {
        double prisInclusiveFragt = 0;

        return prisInclusiveFragt;
    }

    public double prisExclusivFragt(LocalDate date) {
        double salgspris = 0;
        for (Salgslinje salgslinje : salgslinjes) {
            salgslinje.getSalgslinjePris(date);
        }
        return salgspris;
    }

    public double prisInclusivFragt(LocalDate date) {
        double salgPris = 0;
        int pallebehov = 0;
        for (Salgslinje salgslinje : salgslinjes) {
            if (salgslinje.getAntal() > salgslinje.getJuletræ().getAntalPrPalle()) {
                pallebehov = salgslinje.getAntal() / salgslinje.getJuletræ().getAntalPrPalle() + 1;
            } else {
                pallebehov = 1;
            }
            double grossistpallePris = salgslinje.getJuletræ().getJuletræsGrossist().getFragtPrisPrPalle();
            salgPris = prisExclusivFragt(date) + (pallebehov * grossistpallePris);
        }
        return salgPris;
    }
}
