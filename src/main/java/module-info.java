module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens g05 to javafx.fxml;
    exports g05;
}
