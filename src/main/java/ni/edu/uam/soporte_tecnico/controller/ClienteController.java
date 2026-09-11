package ni.edu.uam.soporte_tecnico.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ClienteController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField correoField;

    @FXML
    private TextField telefonoField;

    @FXML
    private ComboBox<String> tipoClienteCombo;

    @FXML
    private TextField documentoField;

    @FXML
    private TextField directorioField;


    @FXML
    public void initialize() {

        tipoClienteCombo.getItems().addAll(
                "Particular",
                "Empresa",
                "Institución"
        );
    }


    @FXML
    private void seleccionarDocumento(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Seleccionar documento de identificación");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "Documentos",
                        "*.pdf",
                        "*.doc",
                        "*.docx",
                        "*.jpg",
                        "*.jpeg",
                        "*.png"
                ),
                new FileChooser.ExtensionFilter(
                        "Todos los archivos",
                        "*.*"
                )
        );

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        File archivo = fileChooser.showOpenDialog(stage);

        if (archivo != null) {
            documentoField.setText(archivo.getAbsolutePath());
        }
    }


    @FXML
    private void seleccionarDirectorio(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();

        directoryChooser.setTitle("Seleccionar directorio del cliente");

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        File directorio = directoryChooser.showDialog(stage);

        if (directorio != null) {
            directorioField.setText(directorio.getAbsolutePath());
        }
    }


    @FXML
    private void guardar(ActionEvent event) {

        if (!validarCampos()) {
            return;
        }

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Cliente guardado",
                "Registro exitoso",
                "El cliente se ha guardado correctamente."
        );
    }


    @FXML
    private void crearSolicitud(ActionEvent event) throws IOException {

        if (!validarCampos()) {
            return;
        }

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/ni/edu/uam/soporte_tecnico/solicitud.fxml"
                )
        );

        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Solicitud de Servicio");
        stage.show();
    }


    @FXML
    private void limpiar(ActionEvent event) {

        nombreField.clear();
        correoField.clear();
        telefonoField.clear();

        tipoClienteCombo.getSelectionModel().clearSelection();

        documentoField.clear();
        directorioField.clear();
    }


    @FXML
    private void cerrar(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.close();
    }


    private boolean validarCampos() {

        if (nombreField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe ingresar el nombre del cliente."
            );

            nombreField.requestFocus();
            return false;
        }

        if (correoField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe ingresar el correo del cliente."
            );

            correoField.requestFocus();
            return false;
        }

        if (!correoField.getText().contains("@")) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Correo inválido",
                    "Ingrese un correo electrónico válido."
            );

            correoField.requestFocus();
            return false;
        }

        if (telefonoField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe ingresar el teléfono del cliente."
            );

            telefonoField.requestFocus();
            return false;
        }

        if (tipoClienteCombo.getValue() == null) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar el tipo de cliente."
            );

            tipoClienteCombo.requestFocus();
            return false;
        }

        if (documentoField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar el documento de identificación."
            );

            return false;
        }

        if (directorioField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING, "Validación", "Campo obligatorio", "Debe seleccionar el directorio del cliente."
            );

            return false;
        }

        return true;
    }


    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String encabezado,
            String mensaje) {

        Alert alert = new Alert(tipo);

        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}