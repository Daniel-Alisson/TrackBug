package com.sistema.trackbug.controllers;

import com.sistema.trackbug.App;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
// ESSA CLASSE PAI VAI PERMITIR AS CLASSES CONTROLADORES TEREM TOTAL ACESSO AOS METODOS DE ALTERAR TELAS E CONFIG DE BOTOES
public class ConfigController {
    @FXML
    private void mudartelaCadastroColaborador(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaCadastroColaborador.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudartelaLoginColaborador(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaLoginColaborador.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarTelaMenuPrincipal(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaMenuPrincipal.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarTelaCadastroFuncionario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaCadastroFuncionario.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarTelaCadastroEquipamento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaCadastroEquipamento.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarTelaEmprestimo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaEmprestimos.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarTelaControleEmprestimos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/sistema/trackbug/telaControleEmprestimos.fxml"));
            Parent newScreenRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newScreenRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sairSistema() {
        Platform.exit();
    }

    protected void configBotoes(Button botao) {
        botao.setOnMouseEntered(event -> expandirBarra(botao));
        botao.setOnMouseExited(event -> recolherBarra(botao));
    }

    protected void expandirBarra(Button botao) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(botao);
        transition.setToY(-5);
        transition.setDuration(Duration.millis(150));
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        transition.play();
    }

    protected void recolherBarra(Button botao) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(botao);
        transition.setToY(0);
        transition.setDuration(Duration.millis(150));
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        transition.play();
    }
}
