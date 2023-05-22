module hu.katolikuskeri.gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.katolikuskeri.gui to javafx.fxml;
    exports hu.katolikuskeri.gui;

    requires VizibicikliKolcsonzoCLI;
}
