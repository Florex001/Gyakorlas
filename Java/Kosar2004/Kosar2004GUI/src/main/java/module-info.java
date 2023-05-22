module hu.katolikuskeri.kosar2004.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Kosar2004CLI;

    opens hu.katolikuskeri.kosar2004.gui to javafx.fxml;
    exports hu.katolikuskeri.kosar2004.gui;
}
