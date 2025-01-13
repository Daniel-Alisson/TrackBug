package com.sistema.trackbug.controllers;

import com.sistema.trackbug.servicos.Equipamento;
import com.sistema.trackbug.usuario.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.Objects;

public class MenuController extends ConfigController {
    // BOTOES DA BARRA LATERAL
    @FXML
    private Button botaoPrincipal, botaoHome, botaoCadastroFuncionario, botaoCadastroEquipamento, botaoEmprestimos, botaoControleEmprestimos, botaoSair;

    // VARIAVEIS DA BARRA LATERAL
    @FXML
    private VBox barraLateral, conteudoBarra;
    private boolean barraExpandida = false;
    @FXML
    private ImageView logo;

    // CAMPOS DA TELA
    @FXML
    private TableView<Funcionario> tabelaFuncionarios;
    @FXML
    private TableColumn<Funcionario, Integer> colunaCodigo;
    @FXML
    private TableColumn<Funcionario, String> colunaNome;
    @FXML
    private TableColumn<Funcionario, LocalDate> colunaData;
    @FXML
    private TableView<Equipamento> tabelaEquipamentos;
    @FXML
    private TableColumn<Equipamento, String> colunaCodigo2;
    @FXML
    private TableColumn<Equipamento, String> colunaDescricao;
    @FXML
    private TableColumn<Equipamento, String> colunaEstadoConservacao;
    @FXML
    private Label alerta1, alerta2;
    @FXML
    public AnchorPane root;

    public void initialize() {
        configBotoes(botaoHome);
        configBotoes(botaoCadastroFuncionario);
        configBotoes(botaoCadastroEquipamento);
        configBotoes(botaoEmprestimos);
        configBotoes(botaoControleEmprestimos);
        configBotoes(botaoSair);
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));
        colunaCodigo2.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaEstadoConservacao.setCellValueFactory(new PropertyValueFactory<>("estadoConservacao"));
        atualizarTabela();
        colunaCodigo.setStyle("-fx-alignment: CENTER;");
        colunaNome.setStyle("-fx-alignment: CENTER;");
        colunaCodigo2.setStyle("-fx-alignment: CENTER;");
        colunaDescricao.setStyle("-fx-alignment: CENTER;");
        colunaEstadoConservacao.setStyle("-fx-alignment: CENTER;");
        colunaData.setStyle("-fx-alignment: CENTER;");
        Image icon = new Image(Objects.requireNonNull(MenuController.class.getResourceAsStream("/com/sistema/trackbug/imagens/unifan.png")));
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

    // METODO PARA ATUALIZAR A TABELA, PEGANDO AS LISTAS ATUALIZADAS E JOGANDO AS INFORMACOES NA TABELA
    private void atualizarTabela() {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(Funcionario.getListaFuncionarios());
        tabelaFuncionarios.setItems(funcionarios);
        alerta1.setText("Tabela atualizada: " + funcionarios.size() + " funcionários\n");
        //System.out.println("Tabela atualizada: " + funcionarios.size() + " funcionários");
        ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(Equipamento.getListaEquipamentos());
        tabelaEquipamentos.setItems(equipamentos);
        alerta2.setText("Tabela atualizada: " + equipamentos.size() + " equipamentos");
        //System.out.println("Tabela atualizada: " + equipamentos.size() + " porcarias");
    }
}