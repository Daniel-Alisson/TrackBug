package com.sistema.trackbug.controllers;

import com.sistema.trackbug.App;
import com.sistema.trackbug.colaborador.Colaborador;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ColaboradorController extends TrocarTelasController {
    @FXML
    private Button botaoCadastro, botaoLogin, botaoSair;

    @FXML
    TextField campoNome;

    @FXML
    TextField campoCpf;

    @FXML
    TextField campoEmail;

    @FXML
    TextField campoSenha;

    @FXML
    TextField campoSenha2;

    @FXML
    Label alerta;

    @FXML
    ProgressBar barra;

    @FXML
    public void initialize() {
        Colaborador admin = new Colaborador("admin", "0", "admin", "1");
        admin.cadastrarColaborador(admin);
        configBotoes(botaoLogin);
        configBotoes(botaoCadastro);
        configBotoes(botaoSair);
    }

    private void configBotoes(Button botao) {
        botao.setOnMouseEntered(event -> expandirBarra(botao));
        botao.setOnMouseExited(event -> recolherBarra(botao));

    }

    private void expandirBarra(Button botao) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(botao);
        transition.setToY(-5);
        transition.setDuration(Duration.millis(150));
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        transition.play();
    }

    private void recolherBarra(Button botao) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(botao);
        transition.setToY(0);
        transition.setDuration(Duration.millis(150));
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        transition.play();
    }

    @FXML
    private void cadastrarColaborador(ActionEvent event) {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String email = campoEmail.getText();
        String senha = campoSenha.getText();
        String senha2 = campoSenha2.getText();

        if(senha.equals(senha2)) {
            Colaborador colaborador = new Colaborador(nome, cpf, email, senha);
            colaborador.cadastrarColaborador(colaborador);
            alerta.setText("Colaborador Cadastrado com sucesso!");

            limparCampos();
        } else {
            alerta.setText("Senhas diferentes");
        }
    }

    @FXML
    private void loginColaborador(ActionEvent event) {
        String email = campoEmail.getText();
        String senha = campoSenha.getText();

        if(Colaborador.loginColaborador(email, senha)) {
            telaMenu(event);
        } else {
            alerta.setText("Email ou senha inválido!");
        }
    }


    @FXML
    private void telaMenu(ActionEvent event) {
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                final int progress = i;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                barra.setProgress(progress / 100.0);
            }
            javafx.application.Platform.runLater(() -> abrirMenu(event));
        }).start();
    }

    private void abrirMenu(ActionEvent event) {
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
    private void limparCampos() {
        if(campoNome != null) {
            campoNome.clear();
        }
        if(campoCpf != null) {
            campoCpf.clear();
        }
        if(campoSenha != null) {
            campoSenha.clear();
        }
        if(campoEmail != null) {
            campoEmail.clear();
        }
    }
    @FXML
    private void sairSistema() {
        Platform.exit();
    }
}
