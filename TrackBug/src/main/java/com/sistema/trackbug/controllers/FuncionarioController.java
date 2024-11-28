package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.usuario.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
    @FXML
    private ImageView logo;

    // CAMPOS DA TELA
    @FXML
    private TextField campoNome, campoFuncao;
    @FXML
    DatePicker campoData;
    @FXML
    Label alerta;
    @FXML
    Button botaoCadastro;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
        configBotoes(botaoCadastro);
        Image icon = new Image(Objects.requireNonNull(FuncionarioController.class.getResourceAsStream("/com/sistema/trackbug/imagens/unifan.png")));
        logo.setImage(icon);
    }

    // METODOS PARA CONFIGURAR A BARRA LATERAL
    @FXML
    public void alternarBarra() {
        if (barraExpandida) {
            barraLateral.setPrefWidth(50);
            botaoPrincipal.setText("☰");
            conteudoBarra.setVisible(false);
            conteudoBarra.setManaged(false);
            logo.setVisible(false);
            logo.setManaged(false);
        } else {
            barraLateral.setPrefWidth(200);
            botaoPrincipal.setText("☰");
            conteudoBarra.setVisible(true);
            conteudoBarra.setManaged(true);
            logo.setVisible(true);
            logo.setManaged(true);
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
