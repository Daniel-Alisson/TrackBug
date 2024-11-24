package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Emprestimo;
import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.usuario.Funcionario;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDateTime;

public class EmprestimoController extends TrocarTelasController {
    @FXML
    private ComboBox<Funcionario> comboFuncionarios;

    @FXML
    private ComboBox<Equipamento> comboEquipamentos;

    @FXML
    private TextArea campoObservacoes;

    @FXML
    Label alerta;

    @FXML
    private VBox barraLateral;

    @FXML
    private VBox conteudoBarra;

    @FXML
    private Button botaoPrincial;

    private boolean barraExpandida = false;

    @FXML
    private void initialize() {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(Funcionario.getListaFuncionarios());
        comboFuncionarios.setItems(funcionarios);
        ObservableList<Equipamento> equipamentosDisponiveis = FXCollections.observableArrayList(Equipamento.getListaEquipamentos());
        comboEquipamentos.setItems(equipamentosDisponiveis);
    }

    @FXML
    public void alternarBarra() {
        if (barraExpandida) {
            barraLateral.setPrefWidth(50);
            botaoPrincial.setText("☰");
            conteudoBarra.setVisible(false);
            conteudoBarra.setManaged(false);
        } else {
            barraLateral.setPrefWidth(200);
            botaoPrincial.setText("☰");
            conteudoBarra.setVisible(true);
            conteudoBarra.setManaged(true);
        }
        barraExpandida = !barraExpandida;
    }

    @FXML
    private void realizarEmprestimo() {
        Funcionario comboF = comboFuncionarios.getValue();
        Equipamento comboE = comboEquipamentos.getValue();
        String observacoes = campoObservacoes.getText();

        if(comboF == null || comboE == null || observacoes.isEmpty()) {
            alerta.setText("Preencha todos os dados");
            return;
        }

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        Emprestimo novoEmprestimo = new Emprestimo(dataHoraAtual, null, comboE, comboF, observacoes);

        Emprestimo.getListaEmprestimos().add(novoEmprestimo);

        Equipamento.getListaEquipamentos().remove(comboE);
        alerta.setText("Empréstimo realizado com sucesso!");
        limparCampos();
    }

    @FXML
    private void limparCampos() {
        campoObservacoes.clear();
        comboEquipamentos.getSelectionModel().clearSelection();
        comboFuncionarios.getSelectionModel().clearSelection();
    }
}
