package com.sistema.trackbug.controllers;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuControlller extends TrocarTelasController {
    @FXML
    private VBox barraLateral;

    @FXML
    private VBox conteudoBarra;

    @FXML
    private Button botaoPrincipal;

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

    private boolean barraExpandida = false;

    public void initialize() {
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

    private void atualizarTabela() {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(Funcionario.getListaFuncionarios());
        tabelaFuncionarios.setItems(funcionarios);
        System.out.println("Tabela atualizada: " + funcionarios.size() + " funcionários");
        ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList(Equipamento.getListaEquipamentos());
        tabelaEquipamentos.setItems(equipamentos);
        System.out.println("Tabela atualizada: " + equipamentos.size() + " porcarias");
    }
}
