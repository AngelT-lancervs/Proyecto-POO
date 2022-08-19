module g05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;

    opens g05 to javafx.fxml;
    exports g05;
    exports g05.controlador;

    opens g05.controlador to javafx.fxml;
    exports g05.modelo;
    opens g05.modelo to javafx.base;
    exports g05.controlador.atencion;
    opens g05.controlador.atencion to javafx.fxml;
    exports g05.controlador.empleado;
    opens g05.controlador.empleado to javafx.fxml;
    exports g05.controlador.cliente;
    opens g05.controlador.cliente to javafx.fxml;
    exports g05.controlador.servicio;
    opens g05.controlador.servicio to javafx.fxml;
    exports g05.controlador.cita;
    opens g05.controlador.cita to javafx.fxml;
}
