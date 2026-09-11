package ni.edu.uam.soporte_tecnico.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Solicitud {

    @FXML
    private ComboBox<String> clienteCombo;

    @FXML
    private TextField correoField;

    @FXML
    private TextField tipoClienteField;

    @FXML
    private TextField asuntoField;

    @FXML
    private ComboBox<String> tipoServicioCombo;

    @FXML
    private RadioButton bajaRadio;

    @FXML
    private RadioButton mediaRadio;

    @FXML
    private RadioButton altaRadio;

    @FXML
    private TextArea descripcionArea;

    @FXML
    private TextField archivoField;

    @FXML
    private TextField evidenciasField;


    @FXML
    public void initialize() {

        clienteCombo.getItems().addAll(
                "Cliente 1",
                "Cliente 2",
                "Cliente 3"
        );

        tipoServicioCombo.getItems().addAll(
                "Soporte técnico",
                "Mantenimiento",
                "Instalación",
                "Configuración",
                "Reparación"
        );
    }


    @FXML
    private void seleccionarArchivo(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Seleccionar archivo adjunto");

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        File archivo = fileChooser.showOpenDialog(stage);

        if (archivo != null) {
            archivoField.setText(archivo.getAbsolutePath());
        }
    }


    @FXML
    private void seleccionarEvidencias(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();

        directoryChooser.setTitle("Seleccionar carpeta de evidencias");

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        File carpeta = directoryChooser.showDialog(stage);

        if (carpeta != null) {
            evidenciasField.setText(carpeta.getAbsolutePath());
        }
    }


    @FXML
    private void guardar(ActionEvent event) {

        if (!validarCampos()) {
            return;
        }

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Solicitud guardada",
                "Registro exitoso",
                "La solicitud se ha guardado correctamente."
        );
    }


    @FXML
    private void crearSolicitud(ActionEvent event) {

        if (!validarCampos()) {
            return;
        }

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Solicitud creada",
                "Operación exitosa",
                "La solicitud de servicio ha sido creada correctamente."
        );
    }


    @FXML
    private void limpiar(ActionEvent event) {

        clienteCombo.getSelectionModel().clearSelection();

        correoField.clear();
        tipoClienteField.clear();
        asuntoField.clear();

        tipoServicioCombo.getSelectionModel().clearSelection();

        bajaRadio.setSelected(false);
        mediaRadio.setSelected(false);
        altaRadio.setSelected(false);

        descripcionArea.clear();

        archivoField.clear();
        evidenciasField.clear();
    }


    @FXML
    private void cerrar(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.close();
    }


    private boolean validarCampos() {

        if (clienteCombo.getValue() == null) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar un cliente."
            );

            clienteCombo.requestFocus();
            return false;
        }

        if (asuntoField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe ingresar el asunto de la solicitud."
            );

            asuntoField.requestFocus();
            return false;
        }

        if (tipoServicioCombo.getValue() == null) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar el tipo de servicio."
            );

            tipoServicioCombo.requestFocus();
            return false;
        }

        if (!bajaRadio.isSelected()
                && !mediaRadio.isSelected()
                && !altaRadio.isSelected()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar una prioridad."
            );

            return false;
        }

        if (descripcionArea.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe ingresar una descripción del problema."
            );

            descripcionArea.requestFocus();
            return false;
        }

        if (archivoField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar un archivo adjunto."
            );

            return false;
        }

        if (evidenciasField.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Validación",
                    "Campo obligatorio",
                    "Debe seleccionar una carpeta de evidencias."
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