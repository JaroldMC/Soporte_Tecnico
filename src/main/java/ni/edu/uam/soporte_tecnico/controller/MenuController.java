package ni.edu.uam.soporte_tecnico.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private void abrirClientes(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ni/edu/uam/soporte_tecnico/clientes.fxml")
        );

        Parent root = loader.load();

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Registro de Clientes");
        stage.show();
    }

    @FXML
    private void abrirSolicitud(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ni/edu/uam/soporte_tecnico/solicitud.fxml")
        );
        Parent root = loader.load();

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Solicitud de Servicio");
        stage.show();
    }

    @FXML
    private void salir(ActionEvent event) {

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                .getScene()
                .getWindow();

        stage.close();
    }
}