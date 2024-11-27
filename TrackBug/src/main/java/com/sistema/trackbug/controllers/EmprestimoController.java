package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Emprestimo;
import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.usuario.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;

public class EmprestimoController extends ConfigController {
    // BOTOES DA BARRA LATERAL
    @FXML
    private Button botaoPrincipal, botaoHome, botaoCadastroFuncionario, botaoCadastroEquipamento, botaoEmprestimos, botaoControleEmprestimos, botaoSair;

    // VARIAVEIS DA BARRA LATERAL
    @FXML
    private VBox barraLateral, conteudoBarra;
    private boolean barraExpandida = false;

    // CAMPOS DA TELA
    @FXML
    private ComboBox<Funcionario> comboFuncionarios;
    @FXML
    private ComboBox<Equipamento> comboEquipamentos;
    @FXML
    private TextArea campoObservacoes;
    @FXML
    Label alerta;

    @FXML
    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
        // JOGANDO AS LISTA DE FUNCIONARIOS E EQUIPAMENTOS NA COMBOBOX
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(Funcionario.getListaFuncionarios());
        comboFuncionarios.setItems(funcionarios);
        ObservableList<Equipamento> equipamentosDisponiveis = FXCollections.observableArrayList(Equipamento.getListaEquipamentos());
        comboEquipamentos.setItems(equipamentosDisponiveis);
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

    // METODO PARA REALIZAR EMPRESTIMO
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

    // METODO PARA LIMPAR CAMPOS
    @FXML
    private void limparCampos() {
        campoObservacoes.clear();
        comboEquipamentos.getSelectionModel().clearSelection();
        comboFuncionarios.getSelectionModel().clearSelection();
    }
}
