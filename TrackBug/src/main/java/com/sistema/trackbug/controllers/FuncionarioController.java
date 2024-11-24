package com.sistema.trackbug.controllers;

import com.sistema.trackbug.usuario.Funcionario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class FuncionarioController extends TrocarTelasController {
    @FXML
    private VBox barraLateral;

    @FXML
    private VBox conteudoBarra;

    @FXML
    private Button botaoPrincipal;

    @FXML
    private TextField campoNome, campoFuncao;

    @FXML
    DatePicker campoData;

    @FXML
    Label alerta;

    private boolean barraExpandida = false;

    @FXML
    public void alternarBarra() {
        if (barraExpandida) {
            barraLateral.setPrefWidth(50);
            botaoPrincipal.setText("☰");
            conteudoBarra.setVisible(false);
            conteudoBarra.setManaged(false);
        } else {
            barraLateral.setPrefWidth(200);
            botaoPrincipal.setText("☰");
            conteudoBarra.setVisible(true);
            conteudoBarra.setManaged(true);
        }
        barraExpandida = !barraExpandida;
    }

    @FXML
    private void cadastrarFuncionario(ActionEvent event) {
        String nome = campoNome.getText();
        String funcao = campoFuncao.getText();
        LocalDate data = campoData.getValue();

        if(nome == null || nome.isEmpty() || funcao == null || funcao.isEmpty() || data == null) {
            alerta.setText("Preencha todos os dados");
            return;
        }
        Funcionario funcionario = new Funcionario(nome, funcao, data);
        funcionario.cadastrarFuncionario(funcionario);
        alerta.setText("Funcionário Cadastrado com sucesso!");
        limparCampos();
        Funcionario.listarFuncionarios();
    }

    private void limparCampos() {
        campoNome.clear();
        campoFuncao.clear();
        campoData.setValue(null);
    }
}
