package ni.edu.uam.soporte_tecnico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/ni/edu/uam/soporte_tecnico/menu.fxml"
                )
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Sistema de Soporte Técnico");
        stage.setScene(scene);
        stage.show();
    }
}


