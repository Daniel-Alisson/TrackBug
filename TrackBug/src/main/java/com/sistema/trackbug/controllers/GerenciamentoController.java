package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Emprestimo;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciamentoController extends TrocarTelasController {
    @FXML
    private VBox barraLateral;

    @FXML
    private VBox conteudoBarra;

    @FXML
    private Button botaoPrincial;

    private boolean barraExpandida = false;

    @FXML
    private ListView<String> listaEquipamentosIndisponiveis;
    @FXML
    private Label detalhesEmprestimo;
    @FXML
    private Label mensagem;

    private ObservableList<Emprestimo> emprestimosAtivos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        emprestimosAtivos.addAll(Emprestimo.getListaEmprestimos());
        listaEquipamentosIndisponiveis.setItems(
                FXCollections.observableArrayList(
                        emprestimosAtivos.stream()
                                .map(emprestimo -> emprestimo.getEquipamento().getDescricao())
                                .toList()
                )
        );

        listaEquipamentosIndisponiveis.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarDetalhesEmprestimo(newValue);
            }
        });
    }

    private void mostrarDetalhesEmprestimo(String descricaoEquipamento) {
        Emprestimo emprestimo = emprestimosAtivos.stream()
                .filter(e -> e.getEquipamento().getDescricao().equals(descricaoEquipamento))
                .findFirst()
                .orElse(null);

        if (emprestimo != null) {
            detalhesEmprestimo.setText(
                    "Funcionário: " + emprestimo.getFuncionario().getNome() + "\n" +
                            "Data de Saída: " + emprestimo.getDataHoraSaida() + "\n" +
                            "Observação: " + emprestimo.getObservacoes()
            );
            mensagem.setText("Equipamento indisponível!");
        }
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
}
