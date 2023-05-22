module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.example.Controlers;
    opens org.example.Controlers to javafx.fxml;
}
