module hu.katolikuskeri.kosar2004.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Kosar2004Cli;

    opens hu.katolikuskeri.kosar2004.gui to javafx.fxml;
    exports hu.katolikuskeri.kosar2004.gui;
}
