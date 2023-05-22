module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.katolikuskeri.taxifuvarok.gui to javafx.fxml;
    exports hu.katolikuskeri.taxifuvarok.gui;
    exports hu.katolikuskeri.taxifuvarok.gui.Controlers;
    opens hu.katolikuskeri.taxifuvarok.gui.Controlers to javafx.fxml;
}
