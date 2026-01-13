package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Controller.udskrivJuletræMagasin("JuleTræ Magasin");
        Application.launch(Gui.class);
    }

    private static void initStorage() {
        JuletræsGrossist juletræsGrossist1 = Controller.createJuletræsGrossist("Hammel juletræer", "2316", 150);
        JuletræsGrossist juletræsGrossist2 = Controller.createJuletræsGrossist("Sommersminde juletræplantage", "34343", 140);

        // Hammel
        Juletræ juletræ1 = Controller.createJuletræ(Sort.NORMANNSGRAN, 200, 100);
        Juletræ juletræ2 = Controller.createJuletræ(Sort.RØDGRAN, 170, 140);

        juletræ1.createPeriodePris(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), 50);
        juletræ1.createPeriodePris(LocalDate.of(2025, 12, 1), LocalDate.of(2025, 12, 24), 200);

        juletræ2.createPeriodePris(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), 50);
        juletræ2.createPeriodePris(LocalDate.of(2025, 12, 1), LocalDate.of(2025, 12, 24), 200);

        juletræsGrossist1.addJuletræ(juletræ1);
        juletræsGrossist1.addJuletræ(juletræ2);

        //Sommersminde
        Juletræ juletræ3 = Controller.createJuletræ(Sort.NOBILIS, 170, 140);
        Juletræ juletræ4 = Controller.createJuletræ(Sort.NORMANNSGRAN, 160, 144);

        juletræ3.createPeriodePris(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), 40);
        juletræ3.createPeriodePris(LocalDate.of(2025, 12, 1), LocalDate.of(2025, 12, 24), 60);

        juletræ4.createPeriodePris(LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 30), 60);
        juletræ4.createPeriodePris(LocalDate.of(2025, 12, 1), LocalDate.of(2025, 12, 24), 75);

        juletræsGrossist2.addJuletræ(juletræ3);
        juletræsGrossist2.addJuletræ(juletræ4);
        //salg
        Salg salg = Controller.createSalg("FDF Viby", LocalDate.of(2025, 11, 2));
        salg.createSalgslinje(333, 5, juletræ1, salg);
        salg.createSalgslinje(250,3,juletræ2,salg);

    }
}
