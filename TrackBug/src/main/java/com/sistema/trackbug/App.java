package com.sistema.trackbug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaInicial.fxml"));
        stage.setScene(new Scene(root.load(), 1024,768));
        stage.setTitle("TrackBug");
        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1024);
        stage.setMaxHeight(768);
        stage.centerOnScreen();
        // 1- ORGANIZAR A PENULTIMA E ULTIMA TELA
        // 2- ADICIONAR UMA FUNCIONALIDADE, PENSEI EM MUDAR O TEMA DO SISTEMA, VISIVEL AO DIA OU TRANSPARENTE A NOITE
        // 3- TENTAR ADICIONAR UM ICONE JUNTO COM O TITULO "TRACK BUG
        // 4- ADICIONAR UMA FOTO DA UNIFAN
        // 5- RESOLVER O PROBLEMA DE HIERARQUIA DA BARRA LATERAL
        // 6- LIMPAR O CÓDIGO
        // 7- SE DER TEMPO, TENTAR ESTILIZAR MELHOR
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
