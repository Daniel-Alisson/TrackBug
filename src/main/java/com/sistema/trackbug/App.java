package com.sistema.trackbug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaInicial.fxml"));
        stage.setScene(new Scene(root.load(), 1536,816));
        stage.setTitle("TrackBug");
        Image icon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/com/sistema/trackbug/imagens/unifan.png")));
        stage.getIcons().add(icon);
        stage.show();
        // RESOLUCAO DO MEU NOTEBOOK É 1536.0 x 816.0
    }

    public static void main(String[] args) {
        launch(args);
    }
}