package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Emprestimo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class GerenciamentoController extends ConfigController {
    // BOTOES DA BARRA LATERAL
    @FXML
    private Button botaoPrincipal, botaoHome, botaoCadastroFuncionario, botaoCadastroEquipamento, botaoEmprestimos, botaoControleEmprestimos, botaoSair;

    // VARIAVEIS DA BARRA LATERAL
    @FXML
    private VBox barraLateral, conteudoBarra;
    private boolean barraExpandida = false;

    // CAMPOS DA TELA
    @FXML
    private ListView<String> listaEquipamentosIndisponiveis;
    @FXML
    private Label detalhesEmprestimo;
    @FXML
    private Label mensagem;

    // LISTA DE EMPRESTIOMS ATIVOS
    private ObservableList<Emprestimo> emprestimosAtivos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
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

    // METODO PARA MOSTRAR DETALHES DO EQUIPAMENTO EMPRESTADO
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

    // METODOS PARA CONFIGURAR A BARRA LATERAL
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
}
