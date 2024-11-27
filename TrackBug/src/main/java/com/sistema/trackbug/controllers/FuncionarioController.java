package com.sistema.trackbug.controllers;

import com.sistema.trackbug.usuario.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class FuncionarioController extends ConfigController {
    // BOTOES DA BARRA LATERAL
    @FXML
    private Button botaoPrincipal, botaoHome, botaoCadastroFuncionario, botaoCadastroEquipamento, botaoEmprestimos, botaoControleEmprestimos, botaoSair;

    // VARIAVEIS DA BARRA LATERAL
    @FXML
    private VBox barraLateral;
    @FXML
    private VBox conteudoBarra;
    private boolean barraExpandida = false;

    // CAMPOS DA TELA
    @FXML
    private TextField campoNome, campoFuncao;
    @FXML
    DatePicker campoData;
    @FXML
    Label alerta;

    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
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

    // METODO PARA CADASTRAR FUNCIONARIOS
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

    // METODO PARA LIMPAR CAMPOS
    private void limparCampos() {
        campoNome.clear();
        campoFuncao.clear();
        campoData.setValue(null);
    }
}
