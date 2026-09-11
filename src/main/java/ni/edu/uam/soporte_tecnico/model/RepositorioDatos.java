package ni.edu.uam.soporte_tecnico.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class RepositorioDatos {

    private static final ObservableList<Cliente> CLIENTES =
            FXCollections.observableArrayList();

    private static final ObservableList<Solicitud> SOLICITUDES =
            FXCollections.observableArrayList();

    private RepositorioDatos() {
    }

    public static ObservableList<Cliente> clientes() {
        return CLIENTES;
    }

    public static ObservableList<Solicitud> solicitudes() {
        return SOLICITUDES;
    }

    public static boolean existeCorreo(String correo) {

        return CLIENTES.stream()
                .anyMatch(cliente ->
                        cliente.getCorreo().equalsIgnoreCase(correo)
                );
    }
}