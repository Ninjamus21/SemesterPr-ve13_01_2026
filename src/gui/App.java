package gui;

import javafx.application.Application;
import storage.Storage;

public class App {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Application.launch(Gui.class);
    }

}
