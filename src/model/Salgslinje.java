package model;

import java.time.LocalDate;

public class Salgslinje {
    private int antal;
    private double aftaltRabatPrTræ;
    private Juletræ juletræ;
    private Salg salg;

    public Salgslinje(int antal, double aftaltRabatPrTræ, Juletræ juletræ, Salg salg) {
        this.antal = antal;
        this.aftaltRabatPrTræ = aftaltRabatPrTræ;
        this.juletræ = juletræ;
        this.salg = salg;
    }

    public int getAntal() {
        return antal;
    }

    public double getAftaltRabatPrTræ() {
        return aftaltRabatPrTræ;
    }

    public Juletræ getJuletræ() {
        return juletræ;
    }

    public Salg getSalg() {
        return salg;
    }

    public double getSalgslinjePris(LocalDate dato){
        double salgslinjepristotal = 0;
        double prisprtræ = juletræ.prisPåDato(dato);

        salgslinjepristotal = (prisprtræ - getAftaltRabatPrTræ()) * getAntal();

        return salgslinjepristotal;
    }
}
