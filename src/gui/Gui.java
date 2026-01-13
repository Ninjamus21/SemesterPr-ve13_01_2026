package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Juletræ;
import model.JuletræsGrossist;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Gui extends Application {
    private Stage primaryStage;
    private final ListView<JuletræsGrossist> grossisterListView = new ListView<>();
    private final ListView<Juletræ> juletræListView = new ListView<>();
    private final TextArea juletræSorteretTextArea = new TextArea();
    private final DatePicker datePicker = new DatePicker();
    private final TextField prisPåDatoTextField = new TextField();


    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ÅrsprøveSæt");
        primaryStage.show();
    }

    private void initContent(GridPane pane) {
        SectionVBox grossistVBox = new SectionVBox("JuletræsGrossister");
        grossistVBox.addLabeledNode("JuletræsGrossister", grossisterListView);
        pane.add(grossistVBox, 0, 0);

        SectionVBox juletræVBox = new SectionVBox("Juletræer");
        juletræVBox.addLabeledNode("Juletræer", juletræListView);
        juletræVBox.addButton("pris på dato", actionEvent -> {
            prispådato();
        });
        juletræVBox.addNode(datePicker);
        juletræVBox.addLabeledNode("Pris", prisPåDatoTextField);
        pane.add(juletræVBox, 1, 0);

        SectionVBox alleJuletræerEfterHøjde = new SectionVBox("Juletræ efterHøjde");
        alleJuletræerEfterHøjde.addButton("Sorter Efter Højde", actionEvent -> {
            // sorter efter højeste juletræ
            // kunne ikke nå
        });
        alleJuletræerEfterHøjde.addLabeledNode("Alle juletræer", juletræSorteretTextArea);
        pane.add(alleJuletræerEfterHøjde, 0, 1);

        // design end logic start
        Controller.getJuletræGrossist().forEach(juletræsGrossist -> grossisterListView.getItems().add(juletræsGrossist));

        updateJuletræListeForGrossistvalg();
        updateFuldJuletræListe();

    }

    public void updateJuletræListeForGrossistvalg() {
        grossisterListView.getSelectionModel().selectedItemProperty().addListener((obs, oldk, newK) -> {
            juletræListView.getItems().clear();

            if (newK != null) {
                newK.getJuletræs().forEach(juletræ -> juletræListView.getItems().add(juletræ));
            }
        });
    }

    public void updateFuldJuletræListe() {
        StringBuilder stringBuilder = new StringBuilder();
        Controller.getJuletræ().forEach(juletræ -> {
            stringBuilder.append(juletræ.getHøjde() + " " + juletræ.getSort() + " " + juletræ.getJuletræsGrossist()).append("\n");
        });
        juletræSorteretTextArea.setEditable(false);
        juletræSorteretTextArea.setText(stringBuilder.toString());
    }

    public void prispådato() {
        Juletræ selectedJuletræ = juletræListView.getSelectionModel().getSelectedItem();
        LocalDate date = datePicker.getValue();
        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("Vælg en dato");
            alert.showAndWait();
        }

        if (selectedJuletræ == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("klik på et juletræ");
            alert.showAndWait();
        } else {
            double pris = selectedJuletræ.prisPåDato(date);
            prisPåDatoTextField.setText(String.valueOf(pris));
        }
    }
}

