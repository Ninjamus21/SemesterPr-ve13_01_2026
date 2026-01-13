package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Juletræ {
    private Sort sort;
    private int højde;
    private int antalPrPalle;
    private JuletræsGrossist juletræsGrossist;
    private ArrayList<PeriodePris> periodePrises = new ArrayList<>();

    public Juletræ(Sort sort, int højde, int antalPrPalle) {
        this.sort = sort;
        this.højde = højde;
        this.antalPrPalle = antalPrPalle;
    }

    public void setJuletræsGrossist(JuletræsGrossist juletræsGrossist) {
        if (this.juletræsGrossist != juletræsGrossist) {
            JuletræsGrossist oldJuletræsGrossist = this.juletræsGrossist;
            if (oldJuletræsGrossist != null) {
                oldJuletræsGrossist.removeJuletræ(this);
            }
            this.juletræsGrossist = juletræsGrossist;
            if (juletræsGrossist != null) {
                juletræsGrossist.addJuletræ(this);
            }
        }
    }

    public PeriodePris createPeriodePris(LocalDate fraDato, LocalDate tilDato, int pris) {
        PeriodePris periodePris = new PeriodePris(fraDato, tilDato, pris);
        periodePrises.add(periodePris);
        return periodePris;
    }

    public Sort getSort() {
        return sort;
    }

    public int getHøjde() {
        return højde;
    }

    public int getAntalPrPalle() {
        return antalPrPalle;
    }

    public JuletræsGrossist getJuletræsGrossist() {
        return juletræsGrossist;
    }

    public ArrayList<PeriodePris> getPeriodePrises() {
        return new ArrayList<>(periodePrises);
    }

    public double prisPåDato(LocalDate salgsDato) {
        double prisForJuletræPåDagen = 0;
        if (getJuletræsGrossist().getJuletræs() == null) {
            throw new RuntimeException("Grossist har ikke nogen juletræer");
        }
        for (PeriodePris periodePris : periodePrises) {
            if (periodePris.getFraDato().isBefore(salgsDato) && periodePris.getTilDato().isAfter(salgsDato)) {

                System.out.println("juletræ inde for periode");
                for (Juletræ juletræ : getJuletræsGrossist().getJuletræs()) {
                    prisForJuletræPåDagen = periodePris.getPris();
                }
            }
        }
        return prisForJuletræPåDagen;
    }


    @Override
    public String toString() {
        return sort + " højde: " + højde + " Maks. " + antalPrPalle + " på en palle.";
    }
}
