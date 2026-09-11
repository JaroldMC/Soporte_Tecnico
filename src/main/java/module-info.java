module ni.edu.uam.soporte_tecnico {
    requires javafx.controls;
    requires javafx.fxml;

    opens ni.edu.uam.soporte_tecnico to javafx.fxml;
    opens ni.edu.uam.soporte_tecnico.controller to javafx.fxml;

    exports ni.edu.uam.soporte_tecnico;
    exports ni.edu.uam.soporte_tecnico.controller;
}