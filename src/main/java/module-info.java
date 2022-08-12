module g05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens g05 to javafx.fxml;
    exports g05;
    exports g05.controlador;

    opens g05.controlador to javafx.fxml;
    exports g05.modelo;
    opens g05.modelo to javafx.base;
}
