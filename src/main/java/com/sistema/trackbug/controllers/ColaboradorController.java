package com.sistema.trackbug.controllers;

import com.sistema.trackbug.App;
import com.sistema.trackbug.colaborador.Colaborador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ColaboradorController extends ConfigController {
    // BOTOES
    @FXML
    private Button botaoCadastro, botaoLogin, botaoSair;

    // CAMPOS DA TELA
    @FXML
    TextField campoNome, campoCpf, campoEmail;
    @FXML
    PasswordField campoSenha, campoSenha2;
    @FXML
    Label alerta;
    @FXML
    ImageView fundo1;

    // BARRA DE CARREGAMENTO
    @FXML
    ProgressBar barra;

    @FXML
    public void initialize() {
        // TESTES
        Colaborador admin = new Colaborador("admin", "0", "admin", "1");
        admin.cadastrarColaborador(admin);
        configBotoes(botaoLogin);
        configBotoes(botaoCadastro);
        configBotoes(botaoSair);
    }

    // METODO PARA CADASTRAR COLABORADORES
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

    // METODO PARA REALIZAR LOGIN DE COLABORADORES
    @FXML
    private void loginColaborador(ActionEvent event) {
        String email = campoEmail.getText();
        String senha = campoSenha.getText();

        if(Colaborador.loginColaborador(email, senha)) {
            carregarBarra(event);
        } else {
            alerta.setText("Email ou senha inválido!");
        }
    }

    // METODO PARA ANIMAÇÃO DA BARRA DE CARREGAMENTO
    @FXML
    private void carregarBarra(ActionEvent event) {
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

    // METODO PARA MUDAR A TELA PARA O MENU PRINCIPAL
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

    // METODO PARA LIMPAR CAMPOS
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
}