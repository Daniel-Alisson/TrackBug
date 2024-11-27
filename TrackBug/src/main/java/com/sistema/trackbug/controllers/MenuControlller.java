package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.usuario.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class MenuControlller extends ConfigController {
    // BOTOES DA BARRA LATERAL
    @FXML
    private Button botaoPrincipal, botaoHome, botaoCadastroFuncionario, botaoCadastroEquipamento, botaoEmprestimos, botaoControleEmprestimos, botaoSair;

    // VARIAVEIS DA BARRA LATERAL
    @FXML
    private VBox barraLateral, conteudoBarra;
    private boolean barraExpandida = false;

    // CAMPOS DA TELA
    @FXML
    private TableView<Funcionario> tabelaFuncionarios;
    @FXML
    private TableColumn<Funcionario, Integer> colunaCodigo;
    @FXML
    private TableColumn<Funcionario, String> colunaNome;
    @FXML
    private TableView<Equipamento> tabelaEquipamentos;
    @FXML
    private TableColumn<Equipamento, String> colunaCodigo2;
    @FXML
    private TableColumn<Equipamento, String> colunaDescricao;

    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigo2.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        atualizarTabela();
        colunaCodigo.setStyle("-fx-alignment: CENTER;");
        colunaNome.setStyle("-fx-alignment: CENTER;");
        colunaCodigo2.setStyle("-fx-alignment: CENTER;");
        colunaDescricao.setStyle("-fx-alignment: CENTER;");
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

    // METODO PARA ATUALIZAR A TABELA, PEGANDO AS LISTAS ATUALIZADAS E JOGANDO AS INFORMACOES NA TABELA
    private void atualizarTabela() {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(Funcionario.getListaFuncionarios());
        tabelaFuncionarios.setItems(funcionarios);
        System.out.println("Tabela atualizada: " + funcionarios.size() + " funcionários");
        ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(Equipamento.getListaEquipamentos());
        tabelaEquipamentos.setItems(equipamentos);
        System.out.println("Tabela atualizada: " + equipamentos.size() + " porcarias");
    }
}