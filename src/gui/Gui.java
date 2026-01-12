package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Gui extends Application {
    private Stage primaryStage;
    private final ListView<String> lvw1 = new ListView<>();

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ÅrsprøveSæt");
        primaryStage.show();
    }

    private void initContent(GridPane pane) {
        SectionVBox vbox1 = new SectionVBox("VBox1");
        vbox1.addLabeledNode("Tekst", lvw1);
        pane.add(vbox1,1,1);

        // Controller.getHolds().forEach(hold -> listviewHold.getItems().add(hold));
        // pane.add(holdVBox,0,0);

        SectionVBox vBox2 = new SectionVBox("VBox2");

    }

}
