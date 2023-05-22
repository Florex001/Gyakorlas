package hu.katolikuskeri.kosar2004.gui;

import java.io.IOException;

import hu.katolikuskeri.kosar2004.cli.Eredmeny;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
